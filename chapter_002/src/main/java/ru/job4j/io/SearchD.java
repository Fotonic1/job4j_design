package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class SearchD  implements FileVisitor<Path> {
    private Map<Node, ArrayList<File>> map = new HashMap<>();


    public List<File> getPaths() {
        return map.values()
                .stream()
                .filter(files -> files.size() > 1)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        File f = file.toFile();
        map.merge(new Node(f.getName(), f.getTotalSpace()),
                new ArrayList<>(List.of(f)),
                (oldV, newV) -> {
            oldV.add(f); return oldV;
        });
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public class Node {
        private final String name;
        private final long size;

        public Node(String name, long size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return size == node.size && Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, size);
        }
    }
}
