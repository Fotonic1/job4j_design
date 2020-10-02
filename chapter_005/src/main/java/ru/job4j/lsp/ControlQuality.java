package ru.job4j.lsp;

import java.util.List;

public class ControlQuality {
    List<StorageFood> list;

    public ControlQuality(StorageFood firstStorage, StorageFood secondStorage, StorageFood thirdStorage) {
        list = List.of(firstStorage, secondStorage, thirdStorage);
    }

    public void replace(Food food) {
        list.forEach(storageFood -> {
            if (storageFood.accept(food)) {
            storageFood.add(food);
        }
        });
    }

    public void replace(List<Food> list) {
        list.forEach(this::replace);
    }
}
