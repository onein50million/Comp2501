import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Contains a registry of Properties
 *
 * @author Daniel Wart
 * @implNote Uses <code>java.util.HashMap</code> internally
 */
public class Agency {
    private final HashMap<String, Property> properties;

    public Agency(final String name) {
        this.properties = new HashMap<>();
    }

    /**
     * @param property Not null
     */
    public void addProperty(final Property property) {
        if (property == null) {
            throw new IllegalArgumentException("property is invalid");
        }
        properties.put(property.getPropertyId(), property);
    }

    public void removeProperty(final String propertyID) {
        properties.remove(propertyID);
    }

    public Property getProperty(final String propertyID) {
        return properties.get(propertyID);
    }

    public double getTotalPropertyValues() {
        return properties.values().stream().mapToDouble(Property::getPriceUsd).sum();
    }

    public ArrayList<Property> getPropertiesWithPools() {
        final var output = properties
                .values()
                .stream()
                .filter(Property::hasSwimmingPool)
                .collect(Collectors.toCollection(ArrayList::new));
        if (output.size() == 0) {
            return null;
        } else {
            return output;
        }
    }

    /**
     * @return an Array of Property between minUsd and maxUsd in price
     */
    public Property[] getPropertiesBetween(final double minUsd, final double maxUsd) {
        final var output = properties
                .values()
                .stream()
                .filter(property -> property.getPriceUsd() >= minUsd && property.getPriceUsd() <= maxUsd)
                .toArray(Property[]::new);
        if (output.length == 0) {
            return null;
        } else {
            return output;
        }
    }

    /**
     * @return an ArrayList of Address on the given street
     */
    public ArrayList<Address> getPropertiesOn(final String street) {
        final var output = properties
                .values()
                .stream()
                .map(Property::getAddress)
                .filter(address -> address.streetName().equals(street))
                .collect(Collectors.toCollection(ArrayList::new));
        if (output.size() == 0) {
            return null;
        } else {
            return output;
        }
    }

    /**
     * @return a hashmap of property ID to Property with the number of bedrooms within the given range
     */
    public HashMap<String, Property> getPropertiesWithBedrooms(final int minBedrooms, final int maxBedrooms) {
        final var output = new HashMap<String, Property>();
        properties
                .values()
                .stream()
                .filter(property -> property.getNumberOfBedrooms() >= minBedrooms && property.getNumberOfBedrooms() <= maxBedrooms)
                .forEach(property -> output.put(property.getPropertyId(), property));
        if (output.size() == 0) {
            return null;
        } else {
            return output;
        }
    }

    /**
     * @return an ArrayList of formatted Strings where each property is of the given type, case-insensitive
     */
    public ArrayList<String> getPropertiesOfType(final String propertyType) {
        final ArrayList<String> outStrings = new ArrayList<>();
        outStrings.add(String.format("Type: %s\n", propertyType.toUpperCase()));
        final var filteredProperties = properties
                .values()
                .stream()
                .filter(property -> property.getType().equalsIgnoreCase(propertyType))
                .collect(Collectors.toCollection(ArrayList::new));

        var propertyIndex = 1;
        for (final var property : filteredProperties) {
            final var outStringBuilder = new StringBuilder();
            outStringBuilder.append(String.format("%s) ", propertyIndex));
            outStringBuilder.append(String.format("Property %s: ", property.getPropertyId()));
            if (property.getAddress().unitNumber() != null) {
                outStringBuilder.append(String.format("unit #%s at ", property.getAddress().unitNumber()));
            }
            outStringBuilder.append(
                    String.format("%s %s %s in %s (%s bedroom%s%s): $%.0f.\n",
                            property.getAddress().streetNumber(),
                            StringHelper.capitalize(property.getAddress().streetName()),
                            property.getAddress().getPostalCode().toUpperCase(),
                            StringHelper.capitalize(property.getAddress().city()),
                            property.getNumberOfBedrooms(),
                            property.getNumberOfBedrooms() == 1 ? "" : "s",
                            property.hasSwimmingPool() ? " plus pool" : "",
                            property.getPriceUsd()
                    )
            );
            propertyIndex += 1;
            outStrings.add(outStringBuilder.toString());

        }
        if (filteredProperties.size() <= 0) {
            outStrings.add("<none found>");
        }
        return outStrings;
    }
}
