/**
 * @author Ruisi Tang and Daniel Wart
 * @version 1.1
 */
public class Novel
{
    private final String title;
    private final String authorName;
    private final int    yearPublished;

    public Novel(String title, String authorName, int yearPublished) {
        this.title = title != null ? title.trim() : null;
        this.authorName = authorName != null ? authorName.trim() : null;
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


    /**
     * @return Returns true if the novel title is not blank, empty or null
     */
    public boolean isTitleValid(){
        return getTitle() != null && !getTitle().isEmpty() && !getTitle().isBlank();
    }

    /**
     * @return Returns true if the novel author name is not blank, empty or null
     */
    public boolean isAuthorValid(){
        return getAuthorName() != null && !getAuthorName().isEmpty() && !getAuthorName().isBlank();
    }
}
