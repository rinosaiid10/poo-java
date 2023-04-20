package net.rino;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class AppFunc {
    public static void main(String[] args) {

        // Consumer est une fonction qui reçois un paramètre de type String et qui ne retourne rien
        Consumer<String> consumer =(input)->{
            System.out.println(input);
        };
        consumer.accept("HELLO");


        // fonction de type String qui na pas de parametre et qui retourne quelque chose
        Supplier<String> supplier =()-> "AZERTY";

        System.out.println(supplier.get());

        // Fonction qui à, deux type generique, et qui reçois un parametre de type input de type int


        Function<Integer, Integer> function = a-> a*4;
        System.out.println(function.apply(43));
    }
}
