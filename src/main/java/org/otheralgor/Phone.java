package org.otheralgor;

public class Phone extends Product{
    String model;

    public Phone(String s) {
        this.model = s;
    }

    public String getModel() {
        return model;
    }

    /*@Override
    boolean subCompare(Product p) {
        if(p instanceof Phone){
            return ((Phone) p).getModel().equals(this.getModel());
        } else {
            return false;
        }
    }*/

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                '}';
    }
}
