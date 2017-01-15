package org.otheralgor;

public class App {


    private String c;

    public App(){
        this("white");
    }

    public App(String s){
       c = s;
   }

    static boolean b1;
    static char ch;

    public static void main(String[] args) {
        int luck = 10;
        if((luck>10 ? luck++: --luck)<10) {
            System.out.print("Bear");
        } if(luck<10) System.out.print("Shark");

        //App a = new App();
        //System.out.println(a.c);

        int x = 1;
        int y = 2;
        int z = x++;
        int a = --y;
        int b = z--;
        b+= ++z;

        int answ = x>a?y>b?y:b:x>z?x:z;

        System.out.println("[[[[[" + answ);

        System.out.println(b1);
        System.out.println(ch);

    }
}
