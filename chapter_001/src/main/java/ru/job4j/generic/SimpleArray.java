package ru.job4j.generic;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] data;
    private int length = 0;

    public SimpleArray(int size) {
        this.data = new Object[size];
    }

    public void add(T model) {
        data[length] = model;
        length++;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, length);
        data[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, length);
        System.arraycopy(data, index + 1, data, index, length - index - 1);
        data[length] = null;
        length--;
    }

    public T get(int index) {
        Objects.checkIndex(index, length);
        return (T) data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return (T) data[index++];
            }
        };
    }
}
