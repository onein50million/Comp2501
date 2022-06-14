
public record Address(String unitNumber, int streetNumber, String streetName, String getPostalCode, String city) {
    /**
     * @param unitNumber    not null and 1 <= length <= 4
     * @param streetNumber  0 <= streetNumber <= 999999
     * @param streetName    not null and  1 <= length <= 20
     * @param getPostalCode not null and 5 <= length <= 6
     * @param city          not null and 1 <= length <= 30
     */
    public Address {

        if (unitNumber != null && (unitNumber.length() < 1 || unitNumber.length() > 4)) {
            throw new IllegalArgumentException(String.format("Invalid unit number: %s", unitNumber));
        }

        if (streetNumber < 0 || streetNumber > 999999) {
            throw new IllegalArgumentException(String.format("Invalid street number: %s", streetNumber));
        }

        if (streetName == null) {
            throw new NullPointerException("Invalid street name: null");
        }
        if (streetName.length() < 1 || streetName.length() > 20) {
            throw new IllegalArgumentException(String.format("Invalid street name: %s", streetName));
        }

        if (getPostalCode == null) {
            throw new NullPointerException("Invalid postal code: null");
        }
        if (getPostalCode.length() < 5 || getPostalCode.length() > 6) {
            throw new IllegalArgumentException(String.format("Invalid postal code: %s", getPostalCode));
        }

        if (city == null) {
            throw new NullPointerException("Invalid city: null");
        }
        if (city.length() < 1 || city.length() > 30) {
            throw new IllegalArgumentException(String.format("Invalid city: %s", city));
        }
    }
}
