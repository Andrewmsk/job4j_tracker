package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        int size = 0;
        Item[] newItems = new Item[100];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName() != null) {
                newItems[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(newItems, size);
    }

    public Item[] findByName(String key) {
        return Arrays.stream(items)
                .filter(Objects::nonNull)
                .filter(a -> a.getName().equals(key))
                .toArray(Item[]::new);
    }
}