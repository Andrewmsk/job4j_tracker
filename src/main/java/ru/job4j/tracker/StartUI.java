package ru.job4j.tracker;

public class StartUI {

    private final Item item = new Item();

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item(1, "First"));
        tracker.add(new Item(2, "Second"));
        tracker.add(new Item(3, "Third"));
        tracker.add(new Item(4, "Fifth"));
        System.out.println(tracker.findById(2));
    }
}
