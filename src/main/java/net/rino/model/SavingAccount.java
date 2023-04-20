package net.rino.model;

public class SavingAccount extends BankAccount{
    // un compte d'epargne contient un taux d'interet

    private double interestRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingAccount(String currency, double initialBalance, double interestRate) {
        super(currency, initialBalance);
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        // super pour rapeller les constructeur de la class parente
        return "Saving Account, interest Rate ="+interestRate+" "+super.toString();
    }

    @Override
    public String getType() {
        return "SAVING_ACCOUNT";
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
