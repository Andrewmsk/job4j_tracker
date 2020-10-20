package ru.job4j.tracker;

public class FindAllAction implements UserAction {

    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length == 0) {
            out.println("No items");
            return true;
        }
        for (Item item: items) {
            out.println(item.getName());
        }
        return true;
    }
}
