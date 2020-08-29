package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        Predicate<String> predicate = s -> {
            var r = s.split(" ");
            return r[r.length - 2].contains("404");
        };
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            in.lines().filter(predicate).forEach(rsl::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
