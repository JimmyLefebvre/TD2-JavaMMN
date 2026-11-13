package EX3;

public class Account {
    private int balance = 100;

    public int getBalance(){
        return balance;
    }

    public void withdraw(int amount) {
        balance = balance - amount;
    }
}
