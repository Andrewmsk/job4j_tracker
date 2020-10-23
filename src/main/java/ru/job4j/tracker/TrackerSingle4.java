package ru.job4j.tracker;

public enum  TrackerSingle4 {
    INSTANCE;

    private final double value = Math.random();

    public double getValue() {
        return value;
    }
}
