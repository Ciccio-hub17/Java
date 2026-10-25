package ex5_1;

import java.util.Locale;

public class Account {

    private final int number;
    private final String owner;
    private double balance;

    public Account (int number, String owner, double initial){
        this.number = number;
        this. owner = owner;
        this.balance = initial;
    }

    public int getNumber (){
        return number;
    }

    public String getOwner (){
        return owner;
    }

    public double getBalance (){
        return balance;
    }

    public void deposit (double amount){
        balance += amount;
    }

    public void withdraw (double amount) throws BankException{
        if (!canWithdraw(amount)){
            throw new BankException("insufficient funds on "+ number);
        }
        balance -= amount;
    }

    protected boolean canWithdraw (double amount){
        return (balance - amount) >= 0;
    }

    public double monthlyFee (){
        return 1.0;
    }

    protected void charge (double amount){
        balance -= amount;
    }

    public String describe (){
        return String.format (Locale.US, "%d,%s, %.2f", number, owner, balance);
    }

    @Override 
    public String toString (){
        return describe ();
    }


}
