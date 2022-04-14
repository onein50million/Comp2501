public class BankAccount {
    double balanceCdn;
    String accountNumber;
    String memberLastName;

    public BankAccount(double balanceCdn, String accountNumber, String memberLastName){
        this.balanceCdn = balanceCdn;
        this.accountNumber = accountNumber;
        this.memberLastName = memberLastName;
    }

    public void withdraw(double amountCdn){
        this.balanceCdn -= amountCdn;
    }
    public void deposit(double amountCdn){
        this.balanceCdn += amountCdn;
    }
    public void transfer(double amountCdn, BankAccount recipient_account){
        recipient_account.deposit(amountCdn);
        this.withdraw(amountCdn);
    }
}
