package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    private final Item item = new Item();

    public static void main(String[] args) {
        StartUI startUI = new StartUI();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
                "dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(startUI.item.getCreated().format(dateTimeFormatter));
    }
}
