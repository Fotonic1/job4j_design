package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Iterable<K> {
    private int size;
    private int modCount;

    private final double loadFactor = 0.75;

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
        if (size >= date.length * loadFactor) {
            plusSize();
        }
        int hash = hash(key);
        int i = hash & (date.length - 1);
        var t = date[i];
        if (t != null && Objects.equals(t.key, key)) {
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
        if (t != null && Objects.equals(t.key, key)) {
            return t.value;
        }
        return null;
    }

    public boolean delete(K key) {
        int i = getIndex(key.hashCode());
        var t = date[i];
        if (t != null && Objects.equals(t.key, key)) {
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
            if (a != null) {
                date[getIndex(a.hash)] = a;
            }
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int s = 0;
            private int in = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return s < size;
            }

            @Override
            public K next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (in < date.length) {
                    if (date[in++] != null) {
                        s++;
                        return date[in].key;
                    }
                }
                return null;
            }
        };
    }
}
