package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

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
                out.println(item.getName());
            }
        } else {
            out.println(String.format("Items with name-%s not found", findItemName));
        }
        return true;
    }
}
