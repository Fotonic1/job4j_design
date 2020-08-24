package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    @Test
    public void thenAdd() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        assertThat(array.get(0), is(1));
    }

//    @Test
//    public void thenRemove() {
//        SimpleArray<Integer> array = new SimpleArray<>(10);
//        array.add(1);
//        array.add(2);
//        array.add(3);
//        array.add(4);
//        array.add(5);
//        array.add(6);
//        array.add(7);
//        array.add(8);
//        array.add(9);
//        array.add(10);
//        //array.remove(0);
//        assertThat(array.get(9), is(10));
//    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void thenException() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.remove(2);
    }

    @Test
    public void thenIt() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.add(2);
        var it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

}