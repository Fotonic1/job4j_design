package ru.job4j.lsp;

import java.util.List;

public class ControlQuality {
    StorageFood firstStorage;
    StorageFood secondStorage;
    StorageFood thirdStorage;

    public ControlQuality(StorageFood firstStorage, StorageFood secondStorage, StorageFood thirdStorage) {
        this.firstStorage = firstStorage;
        this.secondStorage = secondStorage;
        this.thirdStorage = thirdStorage;
    }

    public void replace(Food food) {
        double percent = food.percent();
        if (firstStorage.accept(food)) {
            firstStorage.add(food);
        } else if (secondStorage.accept(food)) {
            secondStorage.add(food);
        } else {
            thirdStorage.add(food);
        }
    }

    public void replace(List<Food> list) {
        list.forEach(this::replace);
    }
}
