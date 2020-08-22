package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int r = row;
        int c = column;
        while (r < data.length) {
                if (c < data[r].length) {
                    return true;
                }
            r++;
            c = 0;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int rsl = 0;
        while (row < data.length) {
                if (column < data[row].length) {
                    return data[row][column++];
                }
                row++;
                column = 0;
        }
        return rsl;
    }
}
