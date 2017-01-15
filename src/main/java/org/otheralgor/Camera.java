package org.otheralgor;

public class Camera extends Product{
    int pixel;

    public Camera() {
    }

    public Camera(String name, Double price) {
        super(name, price);
    }

    public int getPixel() {
        return pixel;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "pixel=" + pixel +
                '}';
    }

    /*
    @Override
    boolean subCompare(Product p) {
        if(p instanceof Camera){
            return ((Camera) p).getPixel() == (this.getPixel());
        } else {
            return false;
        }
    }*/
}
