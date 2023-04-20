package net.rino.exceptions;

public class AccountNotFoundException extends Exception{

    public  AccountNotFoundException(String message){
        // super permet d'appel ici le constructeur de la classe parent(Exception) et lui transmet le message
          super(message);
    }


}
