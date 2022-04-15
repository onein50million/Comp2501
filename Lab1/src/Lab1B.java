/**
 * @author Daniel Wart and Jacob Tsang
 */

public class Lab1B {
    public static void main(String[] args) {
        var students = new Student[]{new Student(
                new Name("Tiger", "Woods"),
                "A00123456",
                new Date(1975, 12, 30),
                true
        ), new Student(
                new Name("Bill", "Gates"),
                "A00987654",
                new Date(1955, 10, 28),
                false
        )};

        for (var student : students) {
            var graduationState = student.graduated ? "has" : "has not";
            System.out.printf("%s (%s) (st# %s) was born on %s. The student %s graduated.\n",
                    student.getName().getFullName(),
                    student.getName().getInitials(),
                    student.getStudentNumber(),
                    student.getDateOfBirth().getYyMmDd(),
                    graduationState);
        }
    }
}
