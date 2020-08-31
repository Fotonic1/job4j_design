package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SearchDouble {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path folder = Paths.get(args[0]);
        search(folder).forEach(System.out::println);
    }

    private static List<File> search(Path folder) throws IOException {
        SearchD searcher = new SearchD();
        Files.walkFileTree(folder, searcher);
        return searcher.getPaths();
    }
}
