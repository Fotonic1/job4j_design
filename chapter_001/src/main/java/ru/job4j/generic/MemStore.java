package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        T old = findById(id);
        if (old != null) {
            mem.set(mem.indexOf(old), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        T old = findById(id);
        if (old != null) {
            return mem.remove(old);
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (var a: mem) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }
}
