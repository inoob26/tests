package org.otheralgor.lambda;


public class Lenovo implements Computer {

    String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Lenovo{" +
                "model : '" + model + '\'' +
                '}';
    }

    @Override
    public String getOs() {
        return "Windows 10";
    }


}
