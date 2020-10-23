package ru.job4j.tracker;

public class TrackerSingle2 {

    private static final TrackerSingle2 INSTANCE = new TrackerSingle2();

    private TrackerSingle2() { }

    public static TrackerSingle2 getInstance() {
        return INSTANCE;
    }
}
