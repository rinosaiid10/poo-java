package net.rino;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.rino.model.BankAccount;
import net.rino.model.CurrentAccount;
import net.rino.model.SavingAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App2 {
    public static void main(String[] args) throws JsonProcessingException {

        // declarer: BankAccount  accounts [] et creer un tableau  de 4 variable:new BankAccout[4]

        BankAccount accounts [] = new BankAccount[4];
        accounts[0]= new CurrentAccount("USD",1500,3000);
        accounts[1]= new CurrentAccount("EURO",1200,4000);
        accounts[2]= new SavingAccount("FCA",1900,3.5);
        accounts[3]= new SavingAccount("MAD",15800,4.5);

         for (BankAccount acc: accounts){

             System.out.println(acc.getBalance());
         }


    //Creons un collection List

        System.out.println("Listes");

        List<BankAccount> bankAccountList = new ArrayList<>();

         bankAccountList.add(new CurrentAccount("USD",1400,3450));
         bankAccountList.add(new CurrentAccount("USD",1560,5000));
         bankAccountList.add(new SavingAccount("USD",1890,5.4));
         bankAccountList.add(new SavingAccount("USD",15120,4.5));

        for (BankAccount acc: accounts){

            System.out.println(acc.getBalance());
        }

        // Collection Map

        Map<String,BankAccount>bankAccountMap =new HashMap<>();

        // creer le HashMap

        bankAccountMap.put("cc1", new CurrentAccount("USD",14070,3000));
        bankAccountMap.put("cc2", new CurrentAccount("FCA",178700,5000));
        bankAccountMap.put("cc3", new SavingAccount("EURO",19800,3.5));
        bankAccountMap.put("cc4", new SavingAccount("MAD",1490,4.5));

        //on recuperer le Map

        BankAccount acc = bankAccountMap.get("cc2");
        System.out.println(acc.toString());

        // Parcourir un map affichons la clé puis apres la valeur

        for (String  key : bankAccountMap.keySet()){
            System.out.println(bankAccountMap.get(key));
        }
        System.out.println("==============");

        for (BankAccount ba : bankAccountMap.values()){
            System.out.println(toJson(ba));
        }

    }


    //Convertir un Object en Map en Json en format formater avec writerWithDefaultPrettyPrinter()

    public   static String toJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

}

/*
App pour class non abstract
public class App2 {
    public static void main(String[] args) throws JsonProcessingException {

        // declarer: BankAccount  accounts [] et creer un tableau  de 4 variable:new BankAccout[4]

        BankAccount accounts [] = new BankAccount[4];
        accounts[0]= new BankAccount("USD",1500);
        accounts[1]= new BankAccount("EURO",1200);
        accounts[2]= new BankAccount("FCA",1900);
        accounts[3]= new BankAccount("MAD",15800);

         for (BankAccount acc: accounts){

             System.out.println(acc.getBalance());
         }


    //Creons un collection List

        System.out.println("Listes");

        List<BankAccount> bankAccountList = new ArrayList<>();

         bankAccountList.add(new BankAccount("USD",1400));
         bankAccountList.add(new BankAccount("USD",1560));
         bankAccountList.add(new BankAccount("USD",1890));
         bankAccountList.add(new BankAccount("USD",15120));

        for (BankAccount acc: accounts){

            System.out.println(acc.getBalance());
        }

        // Collection Map

        Map<String,BankAccount>bankAccountMap =new HashMap<>();

        // creer le HashMap

        bankAccountMap.put("cc1", new BankAccount("USD",14070));
        bankAccountMap.put("cc2", new BankAccount("FCA",178700));
        bankAccountMap.put("cc3", new BankAccount("EURO",19800));
        bankAccountMap.put("cc4", new BankAccount("MAD",1490));

        //on recuperer le Map

        BankAccount acc = bankAccountMap.get("cc2");
        System.out.println(acc.toString());

        // Parcourir un map affichons la clé puis apres la valeur

        for (String  key : bankAccountMap.keySet()){
            System.out.println(bankAccountMap.get(key));
        }
        System.out.println("==============");

        for (BankAccount ba : bankAccountMap.values()){
            System.out.println(toJson(ba));
        }

    }


    //Convertir un Object en Map en Json en format formater avec writerWithDefaultPrettyPrinter()

    public   static String toJson(Object o) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

}

 */