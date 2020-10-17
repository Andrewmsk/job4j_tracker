package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int trackerId = input.askInt("Enter Tracker id: ");
        Item item = tracker.findById(trackerId);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.printf("Tracker with id-%s not found", trackerId);
        }
        return true;
    }
}
