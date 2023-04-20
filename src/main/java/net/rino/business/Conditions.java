package net.rino.business;

import net.rino.model.BankAccount;
 @FunctionalInterface  // permet à une interface fonctionnelle de ne pas avoir plus d'une methode
public interface Conditions <T> {
    // une interface fonctionnelle ne pas avoir plus d'une methode
    // T permet d'utilisir une interface generiquu
    boolean test(T o);
}
