package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChart {
    private List<String> phrases;

    public ConsoleChart(String source) {
        loadPhrases(source);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        new ConsoleChart(args[0]).start();
    }


    public void start() {
        try (Scanner in = new Scanner(System.in);
             PrintWriter log = new PrintWriter(
                     new BufferedOutputStream(
                             new FileOutputStream("./data/chart_log.txt")))) {
            boolean ans = true;
            boolean ex = false;
            while (!ex) {
                String s = in.nextLine();
                log.println(s);
                switch (s) {
                    case "стоп": ans = false;
                    break;
                    case "продолжить": ans = true;
                    break;
                    case "закончить" : ex = true;
                    break;
                    default: if (ans) {
                        answer(log);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void answer(PrintWriter log) {
        String phrase = phrases.get((int) (Math.random() * phrases.size()));
        log.println(phrase);
        System.out.println(phrase);
    }

    public void loadPhrases(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            phrases = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
