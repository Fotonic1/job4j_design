package ru.job4j.softref;

public interface Cash<K, V> {
    V get(K key);
    void put(K key, V value);
}
