package ex5_1;

import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        int a = bank.open("Paul", 100);
        int c = bank.openChecking("Anna", 50, 500);
        int s = bank.openSaving("Paul", 1000, 2);
        int p = bank.openPremium("Luca", 0, 1000);
        bank.getAccount(c).withdraw(300);
        try {
        bank.getAccount(a).withdraw(300);
        } catch (BankException e) {
        IO.println("error: " + e.getMessage());
        }
        ((SavingsAccount) bank.getAccount(s)).addInterest();
        bank.chargeFees();
        for (int n = 1; n <= 4; n++) {
        IO.println(bank.getAccount(n));
        }
        IO.println(bank.countChecking() + " " + bank.bestSavingsOf("Paul") + " | "
        + bank.bestSavingsOf("Anna"));
        IO.println(String.format(Locale.US, "total %.2f", bank.totalDeposits()));
    }
}
