package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgZip {
    private final Map<String, String> arg = new HashMap<>();

    public ArgZip(String[] args) {
        if (!valid(args)) {
            throw new IllegalArgumentException("Arguments not found");
        }
        for (int i = 0; i < args.length; i++) {
            arg.put(args[i++].replaceFirst("-", ""), args[i]);
        }
    }

    public boolean valid(String[] args) {
        return args.length == 6;
    }

    public String directory() {
        return arg.get("d");
    }

    public String exclude() {
        return arg.get("e").replaceFirst("\\*", "");
    }

    public String output() {
        return arg.get("o");
    }
}
