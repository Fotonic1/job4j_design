package ru.job4j.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements StorageFood {

    private List<Food> list = new ArrayList();

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
