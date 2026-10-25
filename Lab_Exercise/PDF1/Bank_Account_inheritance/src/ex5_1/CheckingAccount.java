package ex5_1;

import java.util.Locale;

public class CheckingAccount extends Account{
    private final double overdraft;

    public CheckingAccount (int number, String owner, double initial, double overdraft){
        super (number, owner, initial);
        this.overdraft = overdraft;
    }

    @Override 
    public boolean canWithdraw (double amount){
        return (this.getBalance() - amount) >= (-overdraft);
    }

    @Override 
    public double monthlyFee (){
        return 2.0;
    }

    @Override 
    public String describe (){
        return super.describe() + String.format (Locale.US, ",overdaft %.2f", overdraft);
    }
}
