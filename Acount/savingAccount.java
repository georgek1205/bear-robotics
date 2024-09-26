package Account;

public class savingAccount implements Account{

    private int balance;

    public savingAccount(int balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(int amount) {
        this.balance += amount;
        System.out.println("Your remaining balance : $" + getBalance());
    }

    @Override
    public void withdraw(int amount) {
        if(amount <= this.balance){
            this.balance -= amount;
            System.out.println("Your remaining balance : $" + getBalance());
        }
        else{
            System.out.println("Your account is out of balance!");
        }
    }

    @Override
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
