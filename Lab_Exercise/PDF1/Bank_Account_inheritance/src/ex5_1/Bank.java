package ex5_1;

public class Bank {
    private final int MAX_ACCOUNTS = 100;

    Account[] accounts = new Account[MAX_ACCOUNTS];
    int nAccount = 0;

    public int open (String owner, double initial){
        accounts [nAccount++] = new Account (nAccount, owner, initial);
        return nAccount;
    }

    public int openChecking(String owner, double initial, double overdraft){
        accounts [nAccount++] = new CheckingAccount (nAccount, owner, initial, overdraft);
        return nAccount;
    }

    public int openSaving(String owner, double initial, double rate){
        accounts [nAccount++] = new SavingsAccount (nAccount, owner, initial, rate);
        return nAccount;
    }

    public int openPremium(String owner, double initial, double overdraft){
        accounts [nAccount++] = new PremiumAccount (nAccount, owner, initial, overdraft);
        return nAccount;
    }

    public Account getAccount (int number) throws BankException{
        if (number < 1 || number > nAccount){
            throw new BankException ("unknown account "+ number);
        }
        return accounts[number-1];
    }

    public void chargeFees (){
        for (int i = 0; i < nAccount; i++){
            accounts[i].charge(accounts[i].monthlyFee());
        }
    }

    public int countChecking (){
        int sum = 0;
        for (int i = 0; i < nAccount; i++){
            if (accounts[i] instanceof CheckingAccount){
                sum++;
            }
        }

        return sum;
    }

    public SavingsAccount bestSavingsOf (String owner){
        SavingsAccount max = null;
        for (int i = 0; i < nAccount; i++){
            if (owner.equals(accounts[i].getOwner()) && accounts[i] instanceof SavingsAccount s){
                if (max == null){
                    max = s;
                }
                else if (accounts[i].getBalance() > max.getBalance()){
                    max = s;
                }
            }
        }

        return max;
    }

    public double totalDeposits (){
        double sum = 0;
        for (int i = 0; i < nAccount; i++){
            sum += accounts[i].getBalance();
        }

        return sum;
    }
}
