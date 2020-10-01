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
        if (percent < 0.25) {
            firstStorage.add(food);
        } else if (percent < 0.5) {
            secondStorage.add(food);
        } else if (percent < 0.75) {
            food.setDiscount(0.75);
            secondStorage.add(food);
        } else {
            thirdStorage.add(food);
        }
    }

    public void replace(List<Food> list) {
        list.forEach(this::replace);
    }
}
