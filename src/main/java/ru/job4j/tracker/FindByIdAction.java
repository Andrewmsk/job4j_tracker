package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int trackerId = input.askInt("Enter Tracker id: ");
        Item item = tracker.findById(trackerId);
        if (item != null) {
            out.println(item.getId());
        } else {
            out.println(String.format("Tracker with id-%s not found", trackerId));
        }
        return true;
    }
}
