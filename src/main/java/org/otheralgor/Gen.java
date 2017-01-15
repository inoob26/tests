package org.otheralgor;

public class Gen<T extends Number> {
    T[] ob;

    public Gen() {
    }

    public double getAverage(){
        double sum = 0;

        for (int i = 0; i < ob.length; i++){
            sum += ob[i].doubleValue();
        }

        return sum/ob.length;
    }

    public boolean sameAvg(Gen<?> ob){
        if (getAverage() == ob.getAverage()) {
            return true;
        }else {
            return false;
        }
    }

    public <T extends Comparable<T>, V extends T> boolean isSame(T t, V v){
        if (t.equals(v)){
            return true;
        } else {
            return false;
        }
    }

    public T[] getOb() {
        return ob;
    }
}
