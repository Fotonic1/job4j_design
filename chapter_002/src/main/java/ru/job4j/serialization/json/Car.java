package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Car {
    public boolean work;
    public int weight;
    public String model;
    public Driver driver;
    public String[] passengers;

    public Car(boolean work, int weight, String model, Driver driver, String[] passengers) {
        this.work = work;
        this.weight = weight;
        this.model = model;
        this.driver = driver;
        this.passengers = passengers;
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
        System.out.println(gson.toJson(car));
        final String carJson =
                "{"
                        + "\"work\":false,"
                        + "\"weight\":35,"
                        + "\"model\":\"oka\","
                        + "\"driver\":"
                        + "{"
                        + "\"name\":\"Pasha\""
                        + "},"
                        + "\"passengers\":"
                        + "[\"Olga\",\"Masha\"]"
                        + "}";
        final Car personMod = gson.fromJson(carJson, Car.class);
        System.out.println(personMod);
    }
}
