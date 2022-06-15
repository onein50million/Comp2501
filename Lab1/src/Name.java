/**
 * @author Daniel Wart and Jacob Tsang
 */

public class Name {
    String first;
    String last;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    /** Returns the combination of the first and last name*/
    public String getFullName(){
        return String.format("%s %s", first, last);
    }

    /** Returns the initials of the first and last name*/
    public String getInitials(){
        return String.format("%s.%s",first.charAt(0), last.charAt(0)).toUpperCase();
    }


}
