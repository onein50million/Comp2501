/**
 * @author Daniel Wart
 */
public class StringHelper {
    /**
     * A helper method to capitalize the beginning of each word, with a word being separated by spaces
     */
    public static String capitalize(final String stringToCapitalize) {
        final var splitString = stringToCapitalize.split(" ");
        final var outString = new String[splitString.length];

        var i = 0;
        for (final var substring : splitString) {
            final String capitalizedString = Character.toUpperCase(substring.charAt(0)) +
                    substring.substring(1);
            outString[i] = capitalizedString;
            i += 1;
        }
        return String.join(" ", outString);
    }
}
