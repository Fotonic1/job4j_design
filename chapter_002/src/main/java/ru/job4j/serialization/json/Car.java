package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    private boolean work;
    private int weight;
    private String model;
    private Driver driver;
    private String[] passengers;

    public Car(boolean work, int weight, String model, Driver driver, String[] passengers) {
        this.work = work;
        this.weight = weight;
        this.model = model;
        this.driver = driver;
        this.passengers = passengers;
    }

    public boolean isWork() {
        return work;
    }

    public int getWeight() {
        return weight;
    }

    public String getModel() {
        return model;
    }

    public Driver getDriver() {
        return driver;
    }

    public String[] getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return "Car{"
                + "work=" + work
                + ", weight=" + weight
                + ", model='" + model + '\''
                + ", driver=" + driver
                + ", passengers=" + Arrays.toString(passengers)
                + '}';
    }

    public static void main(String[] args) {
        final Car car = new Car(false, 1400, "lada", new Driver("Vlad"), new String[]{"Yuliya", "Vova"});
        final Gson gson = new GsonBuilder().create();
        final String carJson = gson.toJson(car);
        System.out.println(carJson);
        final Car personMod = gson.fromJson(carJson, Car.class);
        System.out.println(personMod);
    }
}
