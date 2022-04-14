/**
 * @author Daniel Wart and Jacob Tsang
 */

public class BankAccount {
    double balanceCdn;
    String accountNumber;
    String memberLastName;

    public BankAccount(double balanceCdn, String accountNumber, String memberLastName){
        this.balanceCdn = balanceCdn;
        this.accountNumber = accountNumber;
        this.memberLastName = memberLastName;
    }


    //Withdraws money from the account, does not check for overdraw
    public void withdraw(double amountCdn){
        this.balanceCdn -= amountCdn;
    }

    //Deposit money into the account
    public void deposit(double amountCdn){
        this.balanceCdn += amountCdn;
    }

    //Transfer money from this account to recipientAccount
    public void transfer(double amountCdn, BankAccount recipientAccount){
        recipientAccount.deposit(amountCdn);
        this.withdraw(amountCdn);
    }
}
