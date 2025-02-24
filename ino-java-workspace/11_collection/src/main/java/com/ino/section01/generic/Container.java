package com.ino.section01.generic;

public class Container<T> {

    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Container{" +
                "item=" + String.valueOf(item) +
                '}';
    }

    public Container(T item) {
        this.item = item;
    }

    public Container() {};
}
