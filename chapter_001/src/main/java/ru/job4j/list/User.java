package ru.job4j.list;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    public String name;
    public int children;
    public Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        User first = new User("Vlad", 0, new GregorianCalendar(1992, 3, 7));
        User second = new User("Vlad", 0, new GregorianCalendar(1992, 3, 7));
        Map<User, Object> map = new HashMap<>();
        map.put(first, "first");
        map.put(second, "second");
        System.out.println(map);
    }
}
