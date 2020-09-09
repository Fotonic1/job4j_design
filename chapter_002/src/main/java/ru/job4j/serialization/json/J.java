package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;

public class J {
    public static void main(String[] args) {
        Driver driver = new Driver("Vlad");
        final Car car = new Car(false, 1400, "lada", new Driver("Vlad"), new String[]{"Yuliya", "Vova"});
        JSONObject jsonDriver = new JSONObject();
        jsonDriver.put("name", driver.getName());
        JSONArray jsonPassangers = new JSONArray(Arrays.asList(car.getPassengers()));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("work", car.isWork());
        jsonObject.put("weight", car.getWeight());
        jsonObject.put("model", car.getModel());
        jsonObject.put("driver", jsonDriver);
        jsonObject.put("passenger", jsonPassangers);

        System.out.println(jsonObject.toString());

        // Преобразуем объект person в json-строку.
        System.out.println(new JSONObject(car).toString());
    }
}
