package ru.job4j.io;

import java.io.*;

public class Analize {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            StringBuilder rsl = new StringBuilder();
            boolean avail = true;
            while (in.ready()) {
                var s = in.readLine().split(" ");
                if (s.length == 2) {
                    if (avail && (s[0].equals("400") || s[0].equals("500"))) {
                        rsl.append(s[1]).append(";");
                        avail = false;
                    }
                    if (!avail && (s[0].equals("300") || s[0].equals("200"))) {
                        rsl.append(s[1]).append("\n");
                        avail = true;
                    }
                }
            }
            saveTarget(target, rsl.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveTarget(String target, String text) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            out.write(text);
        } catch (Exception e) {
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
