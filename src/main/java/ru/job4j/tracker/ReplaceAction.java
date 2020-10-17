package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int trackerId = input.askInt("Enter Tracker id: ");
        String newItemName = input.askStr("Enter new Item's name: ");
        Item newItem = new Item(newItemName);
        if (tracker.replace(trackerId, newItem)) {
            System.out.println("Item replaced successfully");
            return true;
        } else {
            System.out.println("Replace error.");
            return false;
        }
    }
}
