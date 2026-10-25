package ex5_1;

public class SavingsAccount extends Account{
    private final double rate;

    public SavingsAccount (int number, String owner, double initial, double rate){
        super (number, owner, initial);
        this.rate = rate;
    }

    @Override 
    public double monthlyFee (){
        return 0.0;
    }

    public void addInterest (){
        deposit (getBalance() * rate / 100); 
    }

    @Override 
    public String describe (){
        return super.describe () + ",rate " + rate + "%";
    }


}
