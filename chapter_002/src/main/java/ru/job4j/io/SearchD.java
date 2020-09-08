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
    private Map<Node, File> map = new HashMap<>();
    private Set<File> set = new HashSet<>();


    public Set<File> getPaths() {
        return set;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        File f = file.toFile();
        Node n = new Node(f.getName(), f.getTotalSpace());
        File of = map.getOrDefault(n, null);
        if (of != null) {
           set.add(f);
           set.add(of);
        } else {
            map.put(n, f);
        }
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
