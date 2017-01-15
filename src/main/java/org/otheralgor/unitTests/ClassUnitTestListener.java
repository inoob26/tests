package org.otheralgor.unitTests;

public class ClassUnitTestListener extends Listiner {
    public Integer addListener(Listiner listiner){
        System.out.println("Listener added");
        return 0;
    }

    public void deleteListener(Listiner listiner){
        System.out.println("Listener deleted");
    }
}
