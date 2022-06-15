/**
 * @author Daniel Wart and Jacob Tsang
 */

public class Lab1A {
    public static void main(String[] arguments){
        var b1 = new BankAccount(100.00, "abc123", "gates");
        var b2 = new BankAccount(500.00, "xyz789", "woods");

        System.out.println(b1.balanceCdn);
        b1.withdraw(5.00);
        System.out.println(b1.accountNumber);
        System.out.println(b1.balanceCdn);

        System.out.println("---");

        System.out.println(b2.balanceCdn);
        b2.deposit(23.00);
        System.out.println(b2.memberLastName);
        System.out.println(b2.balanceCdn);

        System.out.println("---");

        b1.transfer(50.00, b2);
        System.out.println(b1.balanceCdn);
        System.out.println(b2.balanceCdn);
    }
}
