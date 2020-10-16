package ru.job4j.tracker;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) throws InterruptedException {
        while (true) {
            this.showMenu();
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item added successfully");
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] runItems = tracker.findAll();
                for (Item item: runItems) {
                    System.out.println(item);
                }
                if (runItems.length == 0) {
                    System.out.println("No items");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.println("Enter Tracker id: ");
                int trackerId = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new Item's name: ");
                String newItemName = scanner.nextLine();
                Item newItem = new Item(newItemName);
                if (tracker.replace(trackerId, newItem)) {
                    System.out.println("Item replaced successfully");
                } else {
                    System.out.println("Replace error.");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.println("Enter Tracker id: ");
                int trackerId = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(trackerId)) {
                    System.out.println("Item deleted successfully");
                } else {
                    System.out.println("Delete error.");
                }

            } else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.println("Enter Tracker id: ");
                int trackerId = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(trackerId);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println(String.format("Tracker with id-%s not found", trackerId));
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ====");
                System.out.println("Enter name: ");
                String findItemName = scanner.nextLine();
                Item[] findItems = tracker.findByName(findItemName);
                if (findItems.length > 0) {
                    for (Item item: findItems) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println(String.format("Items with name-%s not found", findItemName));
                }
            } else if (select == 6) {
                System.out.println("=== Exit Program ====");
                break;
            }
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
                + "6. Exit Program\n"
                + "Select:");
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
