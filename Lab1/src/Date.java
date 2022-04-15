/**
 * @author Daniel Wart and Jacob Tsang
 */

public class Date {
    int year;
    int month;
    int day;


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /** Returns the date formatted as a string following YYYY-MM-DD*/
    public String getYyMmDd(){
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
