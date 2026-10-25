package ex5_1;

import java.util.Locale;

public class PremiumAccount extends CheckingAccount{


    @Override 
    public double monthlyFee(){
        return 0.0;
    }

    public PremiumAccount (int number, String owner, double initial, double overdraft){
        super (number, owner, initial, overdraft);
    }

    @Override 
    public String describe(){
        return super.describe() + String.format (Locale.US, ",premium");
    }
}
