package ru.job4j.list;


import java.util.*;

public class SimpleLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;

    private int size = 0;
    private int modCount = 0;

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> rsl = first;
        for (int i = 1; i < index; i++) {
            rsl = rsl.next;
        }
        return rsl.item;
    }

    public void add(T model) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(last, model, null);
        size++;
        modCount++;
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.prev = newNode;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = modCount;
            private SimpleLinkedList.Node<T> node = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (node != null);
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T rsl = node.item;
                node = node.prev;
                return rsl;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;
        private Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
