package ru.job4j.tracker;

public class TrackerSingle3 {

    private TrackerSingle3() { }

    private static class TrackerSingle3Holder {

        private final static TrackerSingle3 INSTANCE = new TrackerSingle3();
    }

    public static TrackerSingle3 getInstance() {
        return TrackerSingle3Holder.INSTANCE;
    }
}
