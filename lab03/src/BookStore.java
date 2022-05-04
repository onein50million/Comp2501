import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Ruisi Tang
 * @version 1.0
 */
public class BookStore
{
    private final String           bookStoreName;
    private final ArrayList<Novel> novels = new ArrayList<>();

    public BookStore(String bookStoreName)
    {
        if(!bookStoreName.equalsIgnoreCase( "amazon")){
            this.bookStoreName = bookStoreName;
        }else{
            this.bookStoreName = "Chapters";
        }
        novels.add(new Novel("The Adventures of Augie March	"	,	"	Saul Bellow	"	,	1953	));
        novels.add(new Novel("All the King's Men	"	,	"	Robert Penn Warren	"	,	1946	));
        novels.add(new Novel("American Pastoral	"	,	"	Philip Roth	"	,	1997	));
        novels.add(new Novel("An American Tragedy	"	,	"	Theodore Dreiser	"	,	1925	));
        novels.add(new Novel("Animal Farm	"	,	"	George Orwell	"	,	1946	));
        novels.add(new Novel("Appointment in Samarra	"	,	"	John O'Hara	"	,	1934	));
        novels.add(new Novel(null,null	,	0	));
        novels.add(new Novel(null,	"author name 1"	,	0	));
        novels.add(new Novel(""	,	null	,	0	));
        novels.add(new Novel(null,	""	,	0	));
        novels.add(new Novel("title 1  ",null	,	0	));
        novels.add(new Novel(""	,	""	,	0	));
        novels.add(new Novel(""	,	"author name 2",0	));
        novels.add(new Novel("title 2  "	,	null	,	0	));
        novels.add(new Novel("Are You There God? It's Me, Margaret.	"	,	"	Judy Blume	"	,	1970	));
        novels.add(new Novel("The Assistant	"	,	"	Bernard Malamud	"	,	1957	));
        novels.add(new Novel("At Swim-Two-Birds	"	,	"	Flann O'Brien	"	,	1938	));
        novels.add(new Novel("Atonement	"	,	"	Ian McEwan	"	,	2002	));
        novels.add(new Novel("Beloved	"	,	"	Toni Morrison	"	,	1987	));
        novels.add(new Novel("The Berlin Stories	"	,	"	Christopher Isherwood	"	,	1946	));
        novels.add(new Novel("The Big Sleep	"	,	"	Raymond Chandler	"	,	1939	));
        novels.add(new Novel("The Blind Assassin	"	,	"	Margaret Atwood	"	,	2000	));
        novels.add(new Novel("Blood Meridian	"	,	"	Cormac McCarthy	"	,	1986	));
        novels.add(new Novel("Brideshead Revisited	"	,	"	Evelyn Waugh	"	,	1946	));
        novels.add(new Novel("The Bridge of San Luis Rey	"	,	"	Thornton Wilder	"	,	1927	));
        novels.add(new Novel("Call It Sleep	"	,	"	Henry Roth	"	,	1935	));
        novels.add(new Novel("Catch-22	"	,	"	Joseph Heller	"	,	1961	));
        novels.add(new Novel("The Catcher in the Rye	"	,	"	J.D. Salinger	"	,	1951	));
        novels.add(new Novel("A Clockwork Orange	"	,	"	Anthony Burgess	"	,	1963	));
        novels.add(new Novel("The Confessions of Nat Turner	"	,	"	William Styron	"	,	1967	));
        novels.add(new Novel("The Corrections	"	,	"	Jonathan Franzen	"	,	2001	));
        novels.add(new Novel("The Crying of Lot 49	"	,	"	Thomas Pynchon	"	,	1966	));
        novels.add(new Novel("A Dance to the Music of Time	"	,	"	Anthony Powell	"	,	1951	));
        novels.add(new Novel("The Day of the Locust	"	,	"	Nathanael West	"	,	1939	));
        novels.add(new Novel("Death Comes for the Archbishop	"	,	"	Willa Cather	"	,	1927	));
        novels.add(new Novel("A Death in the Family	"	,	"	James Agee	"	,	1958	));
        novels.add(new Novel("The Death of the Heart	"	,	"	Elizabeth Bowen	"	,	1958	));
        novels.add(new Novel("Deliverance	"	,	"	James Dickey	"	,	1970	));
        novels.add(new Novel("Dog Soldiers	"	,	"	Robert Stone	"	,	1974	));
        novels.add(new Novel("Falconer	"	,	"	John Cheever	"	,	1977	));
        novels.add(new Novel("The French Lieutenant's Woman	"	,	"	John Fowles	"	,	1969	));
        novels.add(new Novel("The Golden Notebook	"	,	"	Doris Lessing	"	,	1962	));
        novels.add(new Novel("Go Tell It on the Mountain	"	,	"	James Baldwin	"	,	1953	));
        novels.add(new Novel("Gone with the Wind	"	,	"	Margaret Mitchell	"	,	1936	));
        novels.add(new Novel("The Grapes of Wrath	"	,	"	John Steinbeck	"	,	1939	));
        novels.add(new Novel("Gravity's Rainbow	"	,	"	Thomas Pynchon	"	,	1973	));
        novels.add(new Novel("The Great Gatsby	"	,	"	F. Scott Fitzgerald	"	,	1925	));
        novels.add(new Novel("A Handful of Dust	"	,	"	Evelyn Waugh	"	,	1934	));
        novels.add(new Novel("The Heart Is a Lonely Hunter	"	,	"	Carson McCullers	"	,	1940	));
        novels.add(new Novel("The Heart of the Matter	"	,	"	Graham Greene	"	,	1948	));
        novels.add(new Novel("Herzog	"	,	"	Saul Bellow	"	,	1964	));
        novels.add(new Novel("Housekeeping	"	,	"	Marilynne Robinson	"	,	1981	));
        novels.add(new Novel("	A House for Mr. Biswas	"	,	"	V.S. Naipaul	"	,	1962	));
        novels.add(new Novel("	I, Claudius	"	,	"	Robert Graves	"	,	1934	));
        novels.add(new Novel("	Infinite Jest	"	,	"	David Foster Wallace	"	,	1996	));
        novels.add(new Novel("	Invisible Man	"	,	"	Ralph Ellison	"	,	1952	));
        novels.add(new Novel("	Light in August	"	,	"	William Faulkner	"	,	1932	));
        novels.add(new Novel("	The Lion, The Witch and the Wardrobe	"	,	"	C.S. Lewis	"	,	1950	));
        novels.add(new Novel("	Lolita	"	,	"	Vladimir Nabokov	"	,	1955	));
        novels.add(new Novel("	Lord of the Flies	"	,	"	William Golding	"	,	1954	));
        novels.add(new Novel("	The Lord of the Rings	"	,	"	J.R.R. Tolkien	"	,	1954	));
        novels.add(new Novel("	Loving	"	,	"	Henry Green	"	,	1945	));
        novels.add(new Novel("	Lucky Jim	"	,	"	Kingsley Amis	"	,	1954	));
        novels.add(new Novel("	The Man Who Loved Children	"	,	"	Christina Stead	"	,	1940	));
        novels.add(new Novel("	Midnight's Children	"	,	"	Salman Rushdie	"	,	1981	));
        novels.add(new Novel("	Money	"	,	"	Martin Amis	"	,	1984	));
        novels.add(new Novel("	The Moviegoer	"	,	"	Walker Percy	"	,	1961	));
        novels.add(new Novel("	Mrs. Dalloway	"	,	"	Virginia Woolf	"	,	1925	));
        novels.add(new Novel("	Naked Lunch	"	,	"	William Burroughs	"	,	1959	));
        novels.add(new Novel("	Native Son	"	,	"	Richard Wright	"	,	1940	));
        novels.add(new Novel("	Neuromancer	"	,	"	William Gibson	"	,	1984	));
        novels.add(new Novel("	Never Let Me Go	"	,	"	Kazuo Ishiguro	"	,	2005	));
        novels.add(new Novel("	1984	"	,	"	George Orwell	"	,	1948	));
        novels.add(new Novel("	On the Road	"	,	"	Jack Kerouac	"	,	1957	));
        novels.add(new Novel("	One Flew Over the Cuckoo's Nest	"	,	"	Ken Kesey	"	,	1962	));
        novels.add(new Novel("	The Painted Bird	"	,	"	Jerzy Kosinski	"	,	1965	));
        novels.add(new Novel("	Pale Fire	"	,	"	Vladimir Nabokov	"	,	1962	));
        novels.add(new Novel("	A Passage to India	"	,	"	E.M. Forster	"	,	1924	));
        novels.add(new Novel("	Play It as It Lays	"	,	"	Joan Didion	"	,	1970	));
        novels.add(new Novel("	Portnoy's Complaint	"	,	"	Philip Roth	"	,	1969	));
        novels.add(new Novel("	Possession	"	,	"	A.S. Byatt	"	,	1990	));
        novels.add(new Novel("	The Power and the Glory	"	,	"	Graham Greene	"	,	1939	));
        novels.add(new Novel("	The Prime of Miss Jean Brodie	"	,	"	Muriel Spark	"	,	1961	));
        novels.add(new Novel("	Ragtime	"	,	"	E.L. Doctorow	"	,	1975	));
        novels.add(new Novel("	The Recognitions	"	,	"	William Gaddis	"	,	1955	));
        novels.add(new Novel("	Red Harvest	"	,	"	Dashiell Hammett	"	,	1929	));
        novels.add(new Novel("	Revolutionary Road	"	,	"	Richard Yates	"	,	1961	));
        novels.add(new Novel("	The Sheltering Sky	"	,	"	Paul Bowles	"	,	1949	));
        novels.add(new Novel("	Slaughterhouse-Five	"	,	"	Kurt Vonnegut	"	,	1969	));
        novels.add(new Novel("	Snow Crash	"	,	"	Neal Stephenson	"	,	1992	));
        novels.add(new Novel("	The Sot-Weed Factor	"	,	"	John Barth	"	,	1960	));
        novels.add(new Novel("	The Sound and the Fury	"	,	"	William Faulkner	"	,	1929	));
        novels.add(new Novel("	The Sportswriter	"	,	"	Richard Ford	"	,	1986	));
        novels.add(new Novel("	The Spy Who Came in from the Cold	"	,	"	John le Carr√©	"	,	1964	));
        novels.add(new Novel("	The Sun Also Rises	"	,	"	Ernest Hemingway	"	,	1926	));
        novels.add(new Novel("	Their Eyes Were Watching God	"	,	"	Zora Neale Hurston	"	,	1937	));
        novels.add(new Novel("	Things Fall Apart	"	,	"	Chinua Achebe	"	,	1959	));
        novels.add(new Novel("	To Kill a Mockingbird	"	,	"	Harper Lee	"	,	1960	));
        novels.add(new Novel("	To the Lighthouse	"	,	"	Virginia Woolf	"	,	1929	));
        novels.add(new Novel("	Tropic of Cancer	"	,	"	Henry Miller	"	,	1934	));
        novels.add(new Novel("	Ubik	"	,	"	Philip K. Dick	"	,	1969	));
        novels.add(new Novel("	Under the Net	"	,	"	Iris Murdoch	"	,	1954	));
        novels.add(new Novel("	Under the Volcano	"	,	"	Malcolm Lowry	"	,	1947	));
        novels.add(new Novel("	Watchmen	"	,	"	Alan Moore and Dave Gibbons	"	,	1986	));
        novels.add(new Novel("	White Noise	"	,	"	Don DeLillo	"	,	1985	));
        novels.add(new Novel("	White Teeth	"	,	"	Zadie Smith	"	,	2000	));
        novels.add(new Novel("	Wide Sargasso Sea	"	,	"	Jean Rhys	"	,	1966	));
    }

    /**
     * a function to print all titles
     */
    public void printAllTitles()
    {
        for(Novel novel: novels){
            if(novel.getTitle()!=null && !novel.getTitle().isEmpty())
            {
                if(novel.getTitle()!=null && !novel.getTitle().isBlank())
                {
                    System.out.println(novel.getTitle().trim().toUpperCase());
                }
            }
        }
    }

    /**
     * a function to print titles that contains a defined substring
     * @param substring a defined substring
     * @param caseSensitive a boolean variable to set whether the match up should be case-sensitive
     */
    public void printTitlesContaining(String substring, boolean caseSensitive)
    {
        if (caseSensitive)
        {
            for (Novel novel : novels)
            {
                if (novel.getTitle() != null && !novel.getTitle().isEmpty())
                {
                    if (novel.getTitle() != null && !novel.getTitle().isBlank())
                    {
                        if (novel.getTitle().contains(substring))
                        {
                            System.out.println(novel.getTitle().trim());
                        }
                    }
                }
            }
        } else {
            for (Novel novel : novels)
            {
                if (novel.getTitle() != null && !novel.getTitle().isEmpty())
                {
                    if (novel.getTitle() != null && !novel.getTitle().isBlank())
                    {
                        if (novel.getTitle().toLowerCase().contains(substring.toLowerCase()))
                        {
                            System.out.println(novel.getTitle().trim());
                        }
                    }
                }
            }
        }
    }

    /**
     * print the titles that length equals to the defined string length
     * @param length a defined string length
     */
    public void printTitlesOfLength(int length)
    {
        for (Novel novel : novels)
        {
            if (novel.getTitle() != null && !novel.getTitle().isEmpty())
            {
                if (novel.getTitle() != null && !novel.getTitle().isBlank())
                {
                    if (novel.getTitle().trim().length() == length)
                    {
                        System.out.println(novel.getTitle().trim());
                    }
                }
            }
        }
    }

    /**
     * print the author name starts or ends with a defined substring
     * @param substring a defined substring
     */
    public void printNameStartEndsWith(String substring)
    {
        for (Novel novel : novels)
        {
            if (novel.getAuthorName()!= null && !novel.getAuthorName().isEmpty())
            {
                if (novel.getAuthorName() != null && ! novel.getAuthorName().isBlank())
                {
                    if (novel.getAuthorName().trim().toLowerCase().startsWith(substring.toLowerCase())||novel.getAuthorName().trim().toLowerCase().endsWith(substring.toLowerCase()))
                    {
                        System.out.println(novel.getAuthorName().trim());
                    }
                }
            }
        }
    }

    /**
     * gets the longest author name or title
     * @param property define if the desired output is author name or title
     * @return the longest author name or title or null
     */
    public String getLongest(String property)
    {
        ArrayList<Integer> authorLength = new ArrayList<>();
        ArrayList<Integer> titleLength = new ArrayList<>();

        for(Novel novel: novels)
        {
            if (novel.getAuthorName()!= null && !novel.getAuthorName().isEmpty())
            {
                if (novel.getAuthorName() != null && !novel.getAuthorName().isBlank())
                {
                    authorLength.add(novel.getAuthorName().length());
                }
            }
        }

        for(Novel novel: novels)
        {
            if (novel.getTitle()!= null && !novel.getTitle().isEmpty())
            {
                if (novel.getTitle() != null && !novel.getTitle().isBlank())
                {
                    titleLength.add(novel.getTitle().length());
                }
            }
        }

        if(property.equalsIgnoreCase("author"))
        {
            Integer max = Collections.max(authorLength);
            for(Novel novel: novels)
            {
                if (novel.getAuthorName()!= null && !novel.getAuthorName().isEmpty())
                {
                    if (novel.getAuthorName() != null && !novel.getAuthorName().isBlank())
                    {
                        if (novel.getAuthorName().length() == max)
                        {
                            return novel.getAuthorName().trim();
                        }
                    }
                }
            }
        }else{
            if(property.equalsIgnoreCase("title"))
            {
                Integer max = Collections.max(titleLength);
                for(Novel novel: novels)
                {
                    if (novel.getTitle()!= null && !novel.getTitle().isEmpty())
                    {
                        if (novel.getTitle() != null && !novel.getTitle().isBlank())
                        {
                            if (novel.getTitle().length() == max)
                            {
                                return novel.getTitle().trim();
                            }
                        }
                    }
                }
            }else{
                return null;
            }
        }
        return property;
    }

    public static void main(String[] args)
    {
        BookStore b = new BookStore(args[1]);
        b.printAllTitles();
    }



    //novels.add(new Novel("The Adventures of Augie March", "Saul Bellow", 1953));
}
