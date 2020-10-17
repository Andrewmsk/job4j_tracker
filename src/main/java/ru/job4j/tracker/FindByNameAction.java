package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String findItemName = input.askStr("Enter name: ");
        Item[] findItems = tracker.findByName(findItemName);
        if (findItems.length > 0) {
            for (Item item: findItems) {
                System.out.println(item);
            }
        } else {
            System.out.printf("Items with name-%s not found", findItemName);
        }
        return true;
    }
}
