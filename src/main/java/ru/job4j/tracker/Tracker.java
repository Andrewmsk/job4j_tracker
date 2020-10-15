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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(id);
        items[index] = item;
        return true;
    }
}