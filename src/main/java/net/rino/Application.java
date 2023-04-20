package net.rino;

import net.rino.business.BankAccountService;
import net.rino.business.BankAccountServiceImpl;
import net.rino.exceptions.AccountNotFoundException;
import net.rino.model.BankAccount;
import net.rino.model.CurrentAccount;
import net.rino.model.SavingAccount;

import java.util.List;
import java.util.function.Consumer;

public class Application {
    public static void main(String[] args){
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        // ajouter un compte ( courant)

        bankAccountService.addBankAccount(new CurrentAccount("EURO",1200,500));

        // ajouter un compte ( epargne)

        bankAccountService.addBankAccount(new SavingAccount("EURO",1200,4.5));
        BankAccount bankAccount3 = new CurrentAccount("DOLLAR",1550,2500);
        bankAccount3.setAccountId("CC1");
        bankAccountService.addBankAccount(bankAccount3);
        // Afficher tous les compte
        List<BankAccount> allAccounts = bankAccountService.getAllAccounts();

        //  trois façon de parcourir une lise
        System.out.println("========================1========================");

        /*

         Premier façon (utiliser un seul proceceur de ordinateur, du coup lent)

        for (int i = 0; i< allAccounts.size(); i++){

            System.out.println(allAccounts.get(i).toString());

        }

         */
        System.out.println("===========================1=====================");

       // Deuxieme Façon
        System.out.println("========================2========================");
        for (BankAccount  bankAccount : allAccounts){

            System.out.println(bankAccount.toString());

        }
        System.out.println("========================2========================");


        //Troisieme façon utilise tout le proceceur

        // on creer un objet d'une interface , une interface qui contient une seul methode c'est une interface fonctionnelle
        System.out.println("=======================3-1=========================");

        allAccounts.forEach(new Consumer<BankAccount>() {
        //Cela se faisait avant java 8
        // pour chaque compte la methode forEach appel la methode accept
            @Override
            public void accept(BankAccount account) {
                System.out.println(account.toString());
            }
        });

        System.out.println("=========================3-1=======================");

        // Maintenant c'est comme ça : expression lambda
        // pour chaque object compte on transmet le compte et on afficle "account " c'est une fonction

        System.out.println("=========================3-2=======================");

        allAccounts.forEach(account -> System.out.println(account));

        System.out.println("=========================3-2=======================");


        System.out.println("========================3-3========================");

        allAccounts.forEach(System.out::println);

        System.out.println("========================3-3========================");

        BankAccount accountById = null;
        try {
            accountById = bankAccountService.getAccountById("CC1");
            System.out.println(accountById.toString());

        }catch (AccountNotFoundException e){
            System.out.println(e.getMessage());

        }


        System.out.println("==============================================");
        System.out.println("Suite du programme");



    }
}
