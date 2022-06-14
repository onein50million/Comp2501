import java.util.Arrays;

/**
 * @author Daniel Wart
 */
public final class Property {

    /**
     * Valid types of properties, case insensitive
     */
    public static final String[] VALID_TYPES = {"residence", "commercial", "retail"};
    private final Address address;
    private final int numBedrooms;
    private final boolean swimmingPool;
    private final String type;
    private final String propertyID;
    private double usdPrice;


    /**
     * @param usdPrice    price in usd, above 0.0
     * @param address     address, not null
     * @param numBedrooms 1 <= numBedrooms <= 20
     * @param type        has to not null and be in VALID_TYPES
     * @param propertyID  not null and 1 <= length <= 6
     */
    public Property(final double usdPrice, final Address address, final int numBedrooms, final boolean swimmingPool, final String type, final String propertyID) {
        if (address == null) {
            throw new NullPointerException("Invalid address: null");
        }
        if (numBedrooms < 1 || numBedrooms > 20) {
            throw new IllegalArgumentException(String.format("Invalid number of bedrooms: %s", numBedrooms));
        }

        if (type == null) {
            throw new NullPointerException("Invalid property type: null");
        }
        if (!Arrays.stream(VALID_TYPES).toList().contains(type.toLowerCase())) {
            throw new IllegalArgumentException(String.format("Invalid property type: %s", type));
        }

        if (propertyID == null) {
            throw new NullPointerException("Invalid property id: null");
        }
        if (propertyID.length() < 1 || propertyID.length() > 6) {
            throw new IllegalArgumentException(String.format("Invalid property id: %s", propertyID));
        }
        setPriceUsd(usdPrice);
        this.address = address;
        this.numBedrooms = numBedrooms;
        this.swimmingPool = swimmingPool;
        this.type = type;
        this.propertyID = propertyID;
    }

    public double getPriceUsd() {
        return usdPrice;
    }

    public Address getAddress() {
        return address;
    }

    public int getNumberOfBedrooms() {
        return numBedrooms;
    }

    public boolean hasSwimmingPool() {
        return swimmingPool;
    }

    public String getType() {
        return type;
    }

    public String getPropertyId() {
        return propertyID;
    }

    /**
     * @param usdPrice the price, must be above 0
     */
    public void setPriceUsd(final double usdPrice) {
        if (usdPrice < 0.0) {
            throw new IllegalArgumentException(String.format("Invalid price: %s", usdPrice));
        }
        this.usdPrice = usdPrice;
    }

}
