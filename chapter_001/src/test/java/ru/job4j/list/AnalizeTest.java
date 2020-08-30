package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    @Test
    public void thenAllOne() {
        var analize = new Analize();
        var info = analize.diff(new ArrayList<>(List.of(
                    new Analize.User(1, "1"),
                    new Analize.User(2, "2"),
                    new Analize.User(3, "3"))),
                new ArrayList<>(List.of(
                        new Analize.User(1, "10"),
                        new Analize.User(2, "2"),
                        new Analize.User(4, "4"))));
        assertThat(info, is(new Analize.Info(1, 1, 1)));
    }

    @Test
    public void thenACOne() {
        var analize = new Analize();
        var info = analize.diff(new ArrayList<>(List.of(
                new Analize.User(1, "1"),
                new Analize.User(3, "3"))),
                new ArrayList<>(List.of(
                        new Analize.User(1, "10"),
                        new Analize.User(3, "3"),
                        new Analize.User(4, "4"))));
        assertThat(info, is(new Analize.Info(1, 1, 0)));
    }

    @Test
    public void thenAOne() {
        var analize = new Analize();
        var info = analize.diff(new ArrayList<>(List.of(
                new Analize.User(1, "1"),
                new Analize.User(2, "2"))),
                new ArrayList<>(List.of(
                        new Analize.User(1, "1"),
                        new Analize.User(2, "2"),
                        new Analize.User(3, "3"))));
        assertThat(info, is(new Analize.Info(1, 0, 0)));
    }

    @Test
    public void thenCThree() {
        var analize = new Analize();
        var info = analize.diff(new ArrayList<>(List.of(
                new Analize.User(1, "1"),
                new Analize.User(2, "2"),
                new Analize.User(3, "3"))),
                new ArrayList<>(List.of(
                        new Analize.User(1, "10"),
                        new Analize.User(2, "20"),
                        new Analize.User(3, "40"))));
        assertThat(info, is(new Analize.Info(0, 3, 0)));
    }
}