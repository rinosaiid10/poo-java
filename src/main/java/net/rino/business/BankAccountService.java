package net.rino.business;

import net.rino.exceptions.AccountNotFoundException;
import net.rino.exceptions.BalanceNotSufficientException;
import net.rino.model.BankAccount;

import java.util.List;
import java.util.function.Predicate;

public interface BankAccountService {
    // dans une interface on ne trouve que des methode abstract
    // c'est dans interface on developpement les traitement(logique)

    // creer une methode qui permet d'ajouter des comptes
   BankAccount addBankAccount(BankAccount account);

    // creer un methode qui permet de retourner un liste de compte

   List<BankAccount>getAllAccounts();

   //Methode qui permet de consulter un compte
    BankAccount getAccountById(String id) throws AccountNotFoundException;

    //Methode pour ajouter des nombres aleatoires

      void addRandonData(int size);
      // methode qui permet d'effectuer un versemement dans le compte (crediter)

    // pour crediter un compte il faut id et le montant à verser

    void credit (String accountId , double amount) throws AccountNotFoundException;

    // methode qui permet d'effectuer un retrait dans le compte (dediter)

    // pour debiter un compte il faut id et le montant à verser

    void debit (String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficientException;

    // methode qui permet de transferer un moment vers un autre
     void transfer (String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException;

     // methode qui permet de retourner que les compte de type SavingAccount
    List<BankAccount>  getSavingAccounts();
     // methode qui permet de retourner que les compte de type CurrentAccount
     List<BankAccount>  getCurrentAccounts();
     // methode qui permet de retourner  le  total des soldes des compte
    double getTotalBalance();
     // methode qui permet de chercher un compte selon les critère (par un filtre), filter c'est une methode qui reçois un objet
    // de type Predicates
     List<BankAccount>  searchAccounts(Predicate<BankAccount> filtre);


}
