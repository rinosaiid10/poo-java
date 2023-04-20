package net.rino.model;

// le niveau de protection : public package (par defaut), private, protected

import java.util.Objects;
import java.util.UUID;

public abstract class BankAccount  extends Object{
    //une classe abstract c'est une classe qui ne peut pas etre instencier;
    // objet BankAccount permet de manipuler quoi
    // dans une classe abstrait on peut definir des methode abstraite
    private String accountId;
    private double balance;
    private String currency;
    private AccountStatus status;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus AccountStatus) {
        this.status = status;
    }


//le constructeur BackAccount() , qui permet d'intensier l'objet (BankAccount)

    public  BankAccount (){
        this.accountId= UUID.randomUUID().toString();
        this.status = AccountStatus.CREATED;
    }

    public  BankAccount (String currency, double initialBalance){
        this();// permet d'appeler les parametre d'un autre constructeur
        this.currency =currency;
        this.balance = initialBalance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", status=" + status +
                '}';
    }

    //redefinir la methode equals


    @Override
    public boolean equals(Object acc) {

        // pour affecter un à un objet  à un autre de type objet on faire le sous-casting

        BankAccount account= (BankAccount) acc;
        if (this.accountId.equals(account.accountId)){
           return true;
        }else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.accountId)+
            Objects.hashCode(this.balance)+
            Objects.hashCode(this.currency)+
            Objects.hashCode(this.status);
    }
    // methode abstraite c'est une methode qui n'est pas definir et il devinir dans les classe derivées

    public  abstract  String getType();


    public final void print(){
        // une methode final c'est une methode qu'on peut pas redefinir dans les class derivées
        // une class final c'est un class qui ne pas etre derivée c'est a dire on ne peut herité de cette class
        // variable final , une fois initialiser on plus modifer sa valeur
        System.out.println("------------------BANK----------------");
    }
}
