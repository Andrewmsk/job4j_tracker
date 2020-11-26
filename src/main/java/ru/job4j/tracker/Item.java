package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.Objects;

public class Item implements Comparable<Item> {
    private int id;
    private String name;
    private final LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String itemName) {
        this.name = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Item{"
               + "id=" + id
               + ", name='" + name + '\''
               + ", created=" + created
               + '}';
    }


    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.getName());
    }

    public int compareToReverse(Item o) {
        return o.getName().compareTo(this.name);
    }
}