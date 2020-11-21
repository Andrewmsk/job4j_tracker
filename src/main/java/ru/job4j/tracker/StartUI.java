package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StartUI {
    private int pauseSeconds = 1;
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public StartUI(int menuPauseSeconds, Output out) {
        this.pauseSeconds = menuPauseSeconds;
        this.out = out;
    }

    public void init(
            Input input, Tracker tracker, List<UserAction> actions) throws InterruptedException {

            boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Выберите пункт меню...\n");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
            TimeUnit.SECONDS.sleep(pauseSeconds);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new FindAllAction(out));
        actions.add(new ReplaceAction(out));
        actions.add(new DeleteAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(input, tracker, actions);
    }
}
