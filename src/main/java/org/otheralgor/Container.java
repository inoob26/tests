package org.otheralgor;

public class Container<T extends Product> {
    T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Container() {
    }
}
