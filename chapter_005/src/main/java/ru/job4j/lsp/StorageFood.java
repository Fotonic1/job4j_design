package ru.job4j.lsp;

public interface StorageFood {
    public boolean accept(Food food);
    public boolean add(Food food);
    public boolean replace(Food food, StorageFood storageFood);
    public boolean delete(Food food);
}
