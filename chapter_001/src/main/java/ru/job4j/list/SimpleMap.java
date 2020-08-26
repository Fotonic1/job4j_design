package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Iterable<V> {
    private int size;
    private int modCount;

    public class Node<K, V> {
        K key;
        V value;
        int hash;

        public Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    private Node<K, V>[] date = new Node[16];

    public boolean insert(K key, V value) {
        if (size == date.length) {
            plusSize();
        }
        int hash = hash(key);
        int i = hash & (date.length - 1);
        var t = date[i];
        if (t != null && t.key.equals(key)) {
            t.value = value;
            modCount++;
            return true;
        } else if (t == null) {
            date[i] = new Node<>(key, value, hash);
            size++;
            modCount++;
            return true;
        }

        return false;
    }

    public V get(K key) {
        int i = getIndex(key.hashCode());
        var t = date[i];
        if (t != null && t.key.equals(key)) {
            return t.value;
        }
        return null;
    }

    public boolean delete(K key) {
        int i = getIndex(key.hashCode());
        var t = date[i];
        if (t != null && t.key.equals(key)) {
            date[i] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    private int hash(K key) {
        return key == null ? 0 : key.hashCode();
    }

    private int getIndex(int hash) {
        return hash & (date.length - 1);
    }

    private void plusSize() {
        var oldDate = date;
        date = new Node[date.length * 2];
        for (var a: oldDate) {
            date[getIndex(a.hash)] = a;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int s = 0;
            private int in = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return s < size;
            }

            @Override
            public V next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (in < date.length) {
                    if (date[in] != null) {
                        in++;
                        s++;
                        return date[in].value;
                    }
                }
                return null;
            }
        };
    }
}
