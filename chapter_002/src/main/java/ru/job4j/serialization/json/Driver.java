package ru.job4j.serialization.json;

public class Driver {
    final private String name;

    public Driver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Driver{"
                + "name='" + name + '\''
                + '}';
    }
}
