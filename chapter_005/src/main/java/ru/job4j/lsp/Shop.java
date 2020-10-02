package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements StorageFood {

    private List<Food> list = new ArrayList();

    @Override
    public boolean accept(Food food) {
        double percent = food.percent();
        if (percent < 0.5 && percent >= 0.25) {
            return true;
        } else if (percent >= 0.5 && percent < 0.75) {
            food.setDiscount(0.75);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean add(Food food) {
        return list.add(food);
    }

    @Override
    public boolean replace(Food food, StorageFood storageFood) {
        return storageFood.add(food) && delete(food);
    }

    @Override
    public boolean delete(Food food) {
        return list.remove(food);
    }
}
