package org.otheralgor.cuncurrency;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(){
        System.out.println("На вашем счете не достаточно средств!!!!");
    }
}
