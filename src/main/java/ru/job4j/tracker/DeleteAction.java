package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int trackerId = input.askInt("Enter Tracker id: ");
        if (tracker.delete(trackerId)) {
            out.println("Item deleted successfully");
        } else {
            out.println("Delete error.");
        }
        return true;
    }
}
