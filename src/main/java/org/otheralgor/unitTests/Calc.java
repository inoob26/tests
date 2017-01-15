package org.otheralgor.unitTests;

import java.util.Objects;

public class Calc {
    public int add(int a,int b){
        return a+b;
    }

    public int div(int a,int b){
        Objects.requireNonNull(b,"I can't to div on zero b");
        return a/b;

    }
}
