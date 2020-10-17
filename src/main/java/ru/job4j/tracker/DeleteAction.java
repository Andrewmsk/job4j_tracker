package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int trackerId = input.askInt("Enter Tracker id: ");
        if (tracker.delete(trackerId)) {
            System.out.println("Item deleted successfully");
            return true;
        } else {
            System.out.println("Delete error.");
            return false;
        }
    }
}
