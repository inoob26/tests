package org.otheralgor;


public abstract class Product implements Comparable<Product>{
    String name;
    Double price;

    Product(){}

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Product p) {
        if (p.getPrice() == this.getPrice()){
            return 1;
        } else {
            return 0;
        }
    }

    public Double getPrice() {
        return price;
    }
    //abstract boolean subCompare(Product p);
}
