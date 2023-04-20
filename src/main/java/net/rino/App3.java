package net.rino;

import net.rino.business.BankAccountService;
import net.rino.business.BankAccountServiceImpl;
import net.rino.exceptions.AccountNotFoundException;
import net.rino.exceptions.BalanceNotSufficientException;
import net.rino.model.AccountStatus;
import net.rino.model.BankAccount;
import net.rino.model.CurrentAccount;
import net.rino.model.SavingAccount;
import net.rino.utils.DataTransformationUtils;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class App3 {
    public static void main(String[] args){
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        bankAccountService.addRandonData(10);
        // on ajoputer un compte , modifer son id ,puis afficher

        BankAccount bankAccount1 = new CurrentAccount("DOLLAR",32000,100);
        bankAccount1.setAccountId("CC1");

        BankAccount bankAccount2 = new SavingAccount("DOLLAR",1000,3.2);
        bankAccount2.setAccountId("CC2");

        bankAccountService.addBankAccount(bankAccount1);
        bankAccountService.addBankAccount(bankAccount2);

        /*

        // stream permet de convertir une liste en Stream
        // avec Map on dit dans le stream pour chaque compte on vas le traduire en json
                bankAccountService.getAllAccounts()
                        .stream()
                        // pour chaque objet  on transmet objet account (acc)  à la methode tojson et il me retourne un string

                        .map(DataTransformationUtils::toJson)

                        // pour chaque String on appel la methode println pour l'afficher
                        .forEach(System.out::println);


         */
         BankAccount acc1 = null;
         BankAccount acc2 = null;
        try {
              acc1 = bankAccountService.getAccountById("CC1");
              acc2 = bankAccountService.getAccountById("CC2");

            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println(DataTransformationUtils.toJson(acc2));

            System.out.println("==============DEBITER CC1 ============= ");

            bankAccountService.debit(acc1.getAccountId(),2000);
            System.out.println(DataTransformationUtils.toJson(acc1));

            System.out.println("==============DEBITER CC1 ============= ");


            System.out.println("==============TRANS DE CC1 à CC2 ============= ");

            // on retir 3000 dans cc1 pour ajouter à cc2
            bankAccountService.transfer("CC1", "CC43",3000);

            System.out.println(DataTransformationUtils.toJson(acc1));
            System.out.println(DataTransformationUtils.toJson(acc2));

            System.out.println("==============TRANS DE CC1 à CC2 ============= ");

            // un deuxieme catch à cause de la deuxieme exception de debit
            // on peut aussi utliser catch (exception e) si le traitmement change pas
        } catch (AccountNotFoundException | BalanceNotSufficientException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("============== Suivant ============= ");
        // apres avoir faire la transcation on reaffiche les deux compte
        /*
        Une méthode transactionnelle(transfer) c’est une méthode
        dans laquelle que toutes les opérations (credit ,debit) doit êtres effectues sinon on annule  le tout

         */
        System.out.println(DataTransformationUtils.toJson(acc1));
        System.out.println(DataTransformationUtils.toJson(acc2));
        System.out.println("=========================== ");
        System.out.println("++++++++++++++++++++++++++++");

        bankAccountService.getSavingAccounts()
                .stream()
                .map(DataTransformationUtils::toJson).forEach(System.out::println);

        System.out.println("=============SavingAccount FIN============== ");

        System.out.println("++++++++++++++++++++++++++++");

        bankAccountService.getCurrentAccounts()
                .stream()
                .map(DataTransformationUtils::toJson).forEach(System.out::println);


        System.out.println("=============CurrentAccount FIN============== ");

        System.out.println("Total Balance:"+bankAccountService.getTotalBalance());

        System.out.println("=============Test============= ");

        // on utilise une expression lambda (conditions) c'est une ecriture qui represente objet d'une interface qui contient une seule methode

        List<BankAccount> bankAccountList = bankAccountService.searchAccounts(bankAccount -> (bankAccount.getBalance() > 10000));

        bankAccountList .stream()
                .map(DataTransformationUtils::toJson).forEach(System.out::println);

        System.out.println("=============COMPTE BLOQUE============= ");

        List<BankAccount> bankAccounts = bankAccountService.searchAccounts(acc -> (acc.getStatus() == AccountStatus.BLOCKED));

        bankAccounts .stream()
                .map(DataTransformationUtils::toJson).forEach(System.out::println);

        System.out.println("=============COMPTE ACTIVER============= ");

        List<BankAccount> searchAccounts = bankAccountService.searchAccounts(acc3 -> acc3.getStatus().equals(AccountStatus.ACTIVATED));

         searchAccounts.stream().map(DataTransformationUtils ::toJson ).forEach(System.out::println);


    }
}
