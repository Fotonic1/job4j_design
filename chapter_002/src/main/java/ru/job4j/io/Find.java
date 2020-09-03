package ru.job4j.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Find {
    private Map<String, String> arg = new HashMap<>();

    public Find(String[] args) {
        parse(args);
    }

    private void parse(String[] args) {
        if (args.length != 7) {
            throw new IllegalArgumentException("Arguments not found");
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-m") || args[i].equals("-f") || args[i].equals("-r")) {
                arg.put("type", args[i].replaceFirst("-", ""));
            } else {
                arg.put(args[i++].replaceFirst("-", ""), args[i]);
            }
        }
    }

    public void start() {
        try {
            write(search(type(arg.get("type"))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   private List<Path> search(Predicate<Path> predicate) throws IOException {
        SearchFiles searcher = new SearchFiles(predicate);
        Files.walkFileTree(Path.of(arg.get("d")), searcher);
        return searcher.getPaths();
    }

    private void write(List<Path> list) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(arg.get("o")))) {
            list.stream()
                    .map(a -> a.toFile().getAbsolutePath())
                    .forEach(s -> {
                try {
                    out.write(s);
                    out.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Predicate<Path> type(String t) {
        if (t.equals("r")) {
            return (n -> Pattern.matches(n.toFile().getName(), arg.get("n")));
        } else if (t.equals("m")) {
            return (n -> n.toFile().getName().endsWith(arg.get("n").replaceFirst("\\*", "")));
        } else if (t.equals("f")) {
            return (n -> n.toFile().getName().equals(arg.get("n")));
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Расшифровка аргументов: \n"
                + "-d - директория поиска.\n"
                + "-n - имя файл, маска, либо регулярное выражение.\n"
                + "поиск по -m - маска,-f - полное совпадение, -r регулярное выражение.\n"
                + "-o - результат записать в файл.");
        new Find(args).start();
    }
}
