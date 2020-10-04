package ru.job4j.car;

public interface Parking {
    void park(Car car);
    boolean accept(Car car);
    void park(Truck truck);
    boolean accept(Truck truck);
    boolean full();
    boolean empty();
}
