/**
 * @author Ruisi Tang
 * @version 1.0
 */
public class Novel
{
    private final String title;
    private final String authorName;
    private final int    yearPublished;

    public Novel(String title, String authorName, int yearPublished) {
        this.title = title;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
