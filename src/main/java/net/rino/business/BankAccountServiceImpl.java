package net.rino.business;

import net.rino.exceptions.AccountNotFoundException;
import net.rino.exceptions.BalanceNotSufficientException;
import net.rino.model.AccountStatus;
import net.rino.model.BankAccount;
import net.rino.model.CurrentAccount;
import net.rino.model.SavingAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

  /*  class permettant d'implemementé l'interface
    dans java on ne peut heriter d'une seule class ,
    mais on peut implementer de plusieurs interfaces
     */

public class BankAccountServiceImpl   implements  BankAccountService{

   // l'implementation vas supposer que les compte serons stock dans une liste de compte
    private List<BankAccount> bankAccountList = new ArrayList<>();
    @Override
    public BankAccount addBankAccount(BankAccount account) {
     bankAccountList.add(account);
        return account ; // la variable account est le compte ajouter
    }

    @Override
    public List<BankAccount> getAllAccounts() {

        return bankAccountList; // on retourne tous les comptes qui se trouve dans la liste
    }

    @Override
    public BankAccount getAccountById(String id) throws AccountNotFoundException {
     /*on veux que des objets que getAccountId equals id et vas recuperer le premier
      nouvelle façon pour traiter les listes des tableaux en java, c'est une manière d'utilise API stream de java
      et base sur la programmation Optional, chaque methode appelé on lui transmet une faction:
      une fonction c'est un objet de l'interface qui contient une seule methode
      */
     //Declarative Approach (approche)
      return bankAccountList
              .stream().
              filter(acc->acc.getAccountId().equals(id))
              .findFirst()
              // orElseThrow () est une exception
              //string.format c'est de afficher  le id du compte qui na pas éte trouvé.
              .orElseThrow(()-> new AccountNotFoundException(String.format("BankAccount %s not found", id)));

/*
     //pour chaque objet "BankAccount" ( variable bankAccount) de cette list (bankAccountList)
     // imperative Approach (approche)
       for (BankAccount bankAccount:bankAccountList){
        // on vas comparer id du compte bankAccount  au id dans le parametre de getAccountbYId
        // boucle qui permet de chercher un objet une fois trouver il le retourne
        if (bankAccount.getAccountId().equals(id)){
         return bankAccount;
        }

       }
       // dans java pour gener une expection on utilise le mot clé throw
     // une exception non surveiller
        throw new AccountNotFoundException("BankAccount not found");
       */
    }

    /*
      @Override
    public BankAccount getAccountById(String id) throws Exception {
     //pour chaque objet "BankAccount" ( variable bankAccount) de cette list (bankAccountList)
       for (BankAccount bankAccount:bankAccountList){
        // on vas comparer id du compte bankAccount  au id dans le parametre de getAccountbYId
        // boucle qui permet de chercher un objet une fois trouver il le retourne
        if (bankAccount.getAccountId().equals(id)){
         return bankAccount;
        }

       }
       // dans java pour gener une expection on utilise le mot clé throw
     // c'est une exception surveiller
        throw new Exception("BankAccount not found");
    }
     */

    @Override
    public void addRandonData(int size) {
     AccountStatus [] values = AccountStatus.values();
     Random random = new Random();

     for ( int i = 0; i<size; i++ ){
      BankAccount bankAccount;
      if (Math.random()>0.5){
        bankAccount = new CurrentAccount(Math.random()>0.5? "USA": "MAD",Math.random()*100000, Math.random()*5000);
        bankAccount.setStatus(values[random.nextInt(values.length)]);
      } else {
       bankAccount = new SavingAccount(Math.random()>0.5? "USA": "MAD",Math.random()*100000, 3+Math.random()*5);
       bankAccount.setStatus(values[random.nextInt(values.length)]);
      }
      bankAccountList.add(bankAccount);
     }

    }

    @Override
    public void credit(String accountId, double amount) throws AccountNotFoundException {

     BankAccount accountById = getAccountById(accountId);

     // solde actuel "accountById.getAccountId()" au quel on lui  ajoute un montant

     accountById.setBalance(accountById.getBalance() + amount);

    }

    @Override
    public void debit(String accountId, double amount) throws AccountNotFoundException, BalanceNotSufficientException {

     BankAccount accountById = getAccountById(accountId);

     /*  solde actuel "accountById.getAccountId()" au quel on lui  retir un montant,mais avant on lui
     faire test avant de debiter pour vois sur le solde est suivisant*/

     if (amount> accountById.getBalance()) throw  new BalanceNotSufficientException("Balance not sufficient");
     accountById.setBalance(accountById.getBalance() - amount);

    }

     // debit, credit ,transfer doivent etre transcationnelle
    @Override
    public void transfer(String accountSource, String accountDestination, double amount) throws AccountNotFoundException, BalanceNotSufficientException {
     // pour transferer un monant d'un compte à un autre on vas debiter

     /*
     pour bien faire la trascationelle il faut faire du commit et du rollback( si la transcation se passe mal il faut l'annuler)
     .si la premier et la deuxieme operation se passe bien c'est en se moment qu'on debit,
     mais si il y a exception faudrai annulé (rollback)
     pour faire cela utilser les variable et faire du try catch
      */

     debit(accountSource, amount);
     credit(accountDestination, amount);




    }

 @Override
 public List<BankAccount> getSavingAccounts() {
     // declarative Approach (on filtre)
  // la condition c'est si acc instanceof savingaccount on le laisse sinon on l'ignore

  // on retounre une liste de collect
   return bankAccountList.stream().filter(acc -> acc instanceof SavingAccount).collect(Collectors.toList());

/*
// imperative approach
     List<BankAccount>result = new ArrayList<>();
     for (BankAccount acc: bankAccountList){
      if(acc.getType().equals("SAVING_ACCOUNT")) {
           result.add(acc);
      }
     }
  return result;

 */
 }

 @Override
 public List<BankAccount> getCurrentAccounts() {
  return bankAccountList.stream().filter(acc -> acc instanceof CurrentAccount).collect(Collectors.toList());
 }

 @Override
 public double getTotalBalance() {

     // declarative Approach
  /*
  on map cahque compte et on obtien un list de lambda qui sont que les balance
  reduce prendre etat initial 0 et il faire accumulateur + valeur actuelle
   */
  return bankAccountList.stream().map(account -> account.getBalance() ).reduce(0.0,(a,v)->a+v);
/*
     // imperative Approach
     double sum = 0;
     for(BankAccount acc : bankAccountList){
      sum = sum+acc.getBalance();
     }
  return sum;

 */
 }

 @Override
 public List<BankAccount> searchAccounts(Predicate<BankAccount> filtre) {
  List<BankAccount>result = new ArrayList<>();
  for (BankAccount acc: bankAccountList){
   if(filtre.test(acc)) {
    result.add(acc);
   }
  }
  return result;

 }
}
