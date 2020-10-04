package ru.job4j.car;

public class MainParking implements Parking {

    public MainParking(int carPlace, int truckPlace) {

    }

    @Override
    public void park(Car car) {

    }

    @Override
    public boolean accept(Car car) {
        return false;
    }

    @Override
    public void park(Truck truck) {

    }

    @Override
    public boolean accept(Truck truck) {
        return false;
    }

    @Override
    public boolean full() {
        return true;
    }

    @Override
    public boolean empty() {
        return false;
    }
}
