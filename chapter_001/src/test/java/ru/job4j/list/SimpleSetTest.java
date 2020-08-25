package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void thenTwo() {
        var set = new SimpleSet<Integer>();
        set.add(1);
        set.add(1);
        set.add(2);
        assertThat(set.get(0), is(1));
        assertThat(set.get(1), is(2));
    }
}