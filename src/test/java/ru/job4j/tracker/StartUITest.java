package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenCreateItem() {
        String[] answers = {"First", "Second", "Third"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        for (int i = 0; i < answers.length - 1; i++) {
            StartUI.createItem(input, tracker);
            Item created = tracker.findAll()[i];
            Item expected = new Item(answers[i]);
            assertEquals(expected.getName(), created.getName());
        }
    }
}