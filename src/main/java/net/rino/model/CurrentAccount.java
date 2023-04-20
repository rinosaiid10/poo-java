package net.rino.model;



//CurrentAccount est un type de compte (courant)
// Heritage on herite des attribut et des methode , mais pas des construteur


public class CurrentAccount  extends  BankAccount{

    // overDraft c'est le decouvert

    private double overDraft;


    public CurrentAccount() {
        super();

    }

// en dessous le Construteur de CurrentAccount fait appel au construteur de la classe parante (BankAccount)
    // cela est possible avec super
    public CurrentAccount(String currency, double initialBalance, double overDraft) {
        super(currency, initialBalance);
        this.overDraft = overDraft;
    }

   // on redefinir la methode toString de CurrentAccount


    @Override
    public String toString() {
        return "Current Account, overDraft ="+overDraft+super.toString();
    }

    @Override
    public String getType() {
        return "CURRENT_ACCOUNT";
    }

    public double getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(double overDraft) {
        this.overDraft = overDraft;
    }
}
