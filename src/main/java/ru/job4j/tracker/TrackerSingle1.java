package ru.job4j.tracker;

public class TrackerSingle1 {

    private static TrackerSingle1 trackerSingle1;

    private TrackerSingle1() {
    }

    public static TrackerSingle1 getInstance() {
        if (trackerSingle1 == null) {
            trackerSingle1 = new TrackerSingle1();
        }
        return trackerSingle1;
    }
}
