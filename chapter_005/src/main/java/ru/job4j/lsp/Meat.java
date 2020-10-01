package ru.job4j.lsp;

import java.util.Calendar;

public class Meat extends Food {

    public Meat(String name, Calendar expireDate, Calendar createDate, double price) {
        super(name, expireDate, createDate, price);
    }

    public static void main(String[] args) {
        Apple apple = new Apple("1", Calendar.getInstance(), Calendar.getInstance(), 250);
    }
}
