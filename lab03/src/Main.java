/**
 * @author Ruisi Tang
 * @version 1.0
 */
public class Main
{
    public static void main(String[] args) {
        BookStore bookStore = new BookStore(args[0]);
        bookStore.printAllTitles();
        bookStore.printTitlesContaining("the", true);
        bookStore.printTitlesOfLength(13);
        bookStore.printNameStartEndsWith("aN");
        System.out.println(bookStore.getLongest("authOr"));
        System.out.println(bookStore.getLongest("tItlE"));
        System.out.println(bookStore.getLongest("hehehe"));
    }
}
