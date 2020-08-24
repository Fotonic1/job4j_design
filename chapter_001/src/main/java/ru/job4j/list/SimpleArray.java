package ru.job4j.list;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container = new Object[10];
    private int count = 0;
    private int modCount = 0;

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) container[index];
    }

    public void add(T model) {
        checkLength();
        container[count++] = model;
        modCount++;
    }

    private void checkLength() {
        if (count - 1 == container.length) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = modCount;
            private int i = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return i < count;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[i++];
            }
        };
    }
}