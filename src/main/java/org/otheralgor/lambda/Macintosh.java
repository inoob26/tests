package org.otheralgor.lambda;

public class Macintosh implements Computer {
    String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Macintosh() {
    }

    @Override
    public String getOs() {
        return "MacOSX";
    }

    @Override
    public String toString() {
        return "Macintosh{" +
                "model : '" + model + '\'' +
                '}';
    }
}
