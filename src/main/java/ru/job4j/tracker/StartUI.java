package ru.job4j.tracker;

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
            Input input, Tracker tracker, UserAction[] actions) throws InterruptedException {

            boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = Integer.parseInt(input.askStr("Выберите пункт меню...\n"));
            UserAction action = actions[select];
            run = action.execute(input, tracker);
            TimeUnit.SECONDS.sleep(pauseSeconds);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Output out = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new FindAllAction(out),
                new ReplaceAction(out),
                new DeleteAction(out),
                new FindByIdAction(out),
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(input, tracker, actions);
    }
}
