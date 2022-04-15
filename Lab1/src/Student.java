/**
 * @author Daniel Wart and Jacob Tsang
 */

public class Student {
    Name name;
    String studentNumber;
    Date dateOfBirth;
    boolean graduated;

    public Name getName() {
        return name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public Student(Name name, String studentNumber, Date dateOfBirth, boolean graduated) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.dateOfBirth = dateOfBirth;
        this.graduated = graduated;
    }
}
