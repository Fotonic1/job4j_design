package ru.job4j.softref;

import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CashFile implements Cash<String, String> {
        private final String dir;
        private Map<String, SoftReference<String>> cash = new HashMap<>();

        public CashFile(String dir) {
            this.dir = dir;
        }

        @Override
        public String get(String key) {
            String rsl = "";
            try {
                if (cash.containsKey(key)) {
                    rsl = cash.get(key).get();
                    if (rsl == null) {
                        rsl = readFile(key);
                        cash.put(key, new SoftReference<>(rsl));
                    }
                } else {
                    rsl = readFile(key);
                    cash.put(key, new SoftReference<>(rsl));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return rsl;
        }

        @Override
        public void put(String key, String value) {
            cash.put(key, new SoftReference<>(value));
        }

        private String readFile(String name) throws IOException {
            Path path = Path.of(dir, name);
            File file = path.toFile();
            if (file.exists()) {
                throw new IllegalArgumentException("Invalide name of file");
            }
            return Files.readAllLines(path).stream().collect(Collectors.joining(System.lineSeparator()));
        }
}
