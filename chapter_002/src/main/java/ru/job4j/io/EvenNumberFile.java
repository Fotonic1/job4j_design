package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            var lines = text.toString().split(System.lineSeparator());
            for (var line: lines) {
                int r = Integer.parseInt(line);
                if (r % 2 == 0) {
                    System.out.println("Число четное");
                } else {
                    System.out.println("Число нечетное");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
