package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> last;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public void add(T value) {
        Node<T> node = new Node<T>(last, value, null);
        if (head == null) {
            head = node;
            last = node;
            size++;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = head;
        head = head.next;
        node.next = null;
        size--;
    }

    public T deleteLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = last;
        if (last == head) {
            last = null;
            head = null;
        } else {
            last = last.prev;
            node.prev = null;
        }
        size--;
        return node.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> prev, T value, Node<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
