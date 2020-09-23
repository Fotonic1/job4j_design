package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return search(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return search(value, comparator.reversed());
    }

    private  <T> T search(List<T> value, Comparator<T> comparator) {
        if (value.isEmpty()) {
          return null;
        }
        var it = value.iterator();
        var rsl = it.next();
        while (it.hasNext()) {
            var temp = it.next();
            if (comparator.compare(rsl, temp) < 0) {
                rsl = temp;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 20, 5646, 87, 654, 21);
        MaxMin m = new MaxMin();
        System.out.println(m.max(list, Comparator.naturalOrder()));
        System.out.println(m.min(list, Comparator.naturalOrder()));
    }
}
