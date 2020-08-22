package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return newPoint(point) != -1;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        point = newPoint(point);
        return data[point++];
    }

    private int newPoint(int point) {
        int p = point;
        while (p < data.length) {
            if (data[p] % 2 == 0) {
                return p;
            }
            p++;
        }
        return -1;
    }
}
