package ru.job4j.lsp;

import java.util.Calendar;
import java.util.Date;

public class Food {
    protected String name;
    protected Calendar expireDate;
    protected Calendar createDate;
    double price;
    double discount;

    public Food(String name, Calendar expireDate, Calendar createDate, double price) {
        this.name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public String getName() {
        return name;
    }

    public Calendar getExpireDate() {
        return expireDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        price = price * discount / 100;
    }

    public double percent() {
        long create = createDate.getTimeInMillis();
        long expired = expireDate.getTimeInMillis();
        return (double) ((new Date().getTime() - expired) / (create - expired));
    }
}
