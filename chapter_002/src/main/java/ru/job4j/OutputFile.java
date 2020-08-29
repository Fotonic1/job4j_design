package ru.job4j;

import java.io.FileOutputStream;
import java.util.List;

public class OutputFile {

    public static void main(String[] args) {
        List<Integer> array = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int a : array) {
                for (int b : array) {
                    out.write((a + "*" + b + "=" + (a * b) + System.lineSeparator()).getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
