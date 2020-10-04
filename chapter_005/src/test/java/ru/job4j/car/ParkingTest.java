package ru.job4j.car;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ParkingTest {
    @Test
    public void whenParkCar() {
        Parking parking = new MainParking(1, 1);
        Car car = new Cars();
        Truck truck = new Trucks();
        parking.park(car);
        parking.park(truck);
        assertThat(parking.full(), is(true));
    }

    @Test
    public void whenNotEmpty() {
        Parking parking = new MainParking(1, 1);
        Car car = new Cars();
        Truck truck = new Trucks();
        parking.park(car);
        assertThat(parking.empty(), is(false));
    }

    @Test
    public void whenNotPlace() {
        Parking parking = new MainParking(1, 1);
        Car car = new Cars();
        Truck truck = new Trucks();
        parking.park(car);
        parking.park(truck);
        assertThat(parking.accept(new Cars()), is(false));
    }

}