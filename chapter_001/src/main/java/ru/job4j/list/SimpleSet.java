package ru.job4j.list;

public class SimpleSet<T> extends SimpleArray<T> {
    @Override
    public void add(T model) {
        if (check(model)) {
            super.add(model);
        }
    }

    private boolean check(T model) {
        var it = iterator();
        boolean rsl = true;
        while (it.hasNext()) {
            if (it.next().equals(model)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
