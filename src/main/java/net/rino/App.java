package net.rino;

import net.rino.model.BankAccount;
import net.rino.model.CurrentAccount;
import net.rino.model.SavingAccount;

public class App {
    public static void main(String[] args) {

        // pour utiliser un objet ou une class pour utiliser il faut intensier

        BankAccount account1;

       //on creer un cmpte

        account1= new CurrentAccount();

        //account1.setAccountId("123-543");
        account1.setCurrency("FCFA");
        account1.setBalance(760);

        printAccount(account1);

        //creer un compte à partir de la methode printAccount

        BankAccount account2 = new CurrentAccount("FCFA",1200,4000);
        printAccount(account2);

        BankAccount account3 = new SavingAccount("FCFA",1200,3.4);

        System.out.println("=========================================");
        account3.setAccountId(account2.getAccountId());

        System.out.println(account2);
        System.out.println(account3);
        System.out.println("=========================================");

        if (account2.hashCode()==account3.hashCode()){
            System.out.println("les deux compte ont le même etat");
        } else {
            System.out.println("les deux compte n'ont pas  le même etat");
        }



        System.out.println("=========================================");

        System.out.println(account2==account3);

        System.out.println(account2.equals(account3));


        System.out.println("===========================================");



        // la methode equals compare l'addresse memoire pas etat des objet



  }

   public static void printAccount(BankAccount account){
       System.out.println("AccountID ="+ account.getAccountId());
       System.out.println("Balance="+ account.getBalance());
       System.out.println("Status="+account.getStatus());
       System.out.println("Currrency="+account.getCurrency());

   }

}


/*
Application(App) avec une classe non abstract

public class App {
    public static void main(String[] args) {

        // pour utiliser un objet ou une class pour utiliser il faut intensier

        BankAccount account1;

       //on creer un cmpte

        account1= new BankAccount();

        //account1.setAccountId("123-543");
        account1.setCurrency("FCFA");
        account1.setBalance(760);

        printAccount(account1);

        //creer un compte à partir de la methode printAccount

        BankAccount account2 = new BankAccount("FCFA",1200);
        printAccount(account2);

        BankAccount account3 = new BankAccount("FCFA",1200);

        System.out.println("=========================================");
        account3.setAccountId(account2.getAccountId());

        System.out.println(account2);
        System.out.println(account3);
        System.out.println("=========================================");

        if (account2.hashCode()==account3.hashCode()){
            System.out.println("les deux compte ont le même etat");
        } else {
            System.out.println("les deux compte n'ont pas  le même etat");
        }



        System.out.println("=========================================");

        System.out.println(account2==account3);

        System.out.println(account2.equals(account3));


        System.out.println("===========================================");



        // la methode equals compare l'addresse memoire pas etat des objet



  }

   public static void printAccount(BankAccount account){
       System.out.println("AccountID ="+ account.getAccountId());
       System.out.println("Balance="+ account.getBalance());
       System.out.println("Status="+account.getStatus());
       System.out.println("Currrency="+account.getCurrency());

   }

}
 */