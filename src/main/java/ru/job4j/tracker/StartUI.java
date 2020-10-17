package ru.job4j.tracker;

import java.util.concurrent.TimeUnit;

public class StartUI {

        public void init(Input input, Tracker tracker, UserAction[] actions) throws InterruptedException {
            boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Выберите пункт меню...\n"));
            UserAction action = actions[select];
            run = action.execute(input, tracker);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private void showMenu() {
        System.out.println("\nMenu.");
        System.out.println("0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program");
    }

    public static void main(String[] args) throws InterruptedException {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
