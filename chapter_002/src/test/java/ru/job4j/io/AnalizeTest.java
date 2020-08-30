package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    @Test
    public void unavailable() {
        Analize analize = new Analize();
        analize.unavailable("./data/test_log.txt", "./data/test_un.txt");
        try (BufferedReader in = new BufferedReader(new FileReader("./data/test_un.txt"))){
            assertThat(in.lines().collect(Collectors.toList()),is(List.of("10:57:01;10:59:01", "11:01:02;11:02:02")));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}