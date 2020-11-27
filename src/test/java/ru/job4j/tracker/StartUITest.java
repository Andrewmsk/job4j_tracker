package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() throws InterruptedException {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(0, out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() throws InterruptedException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {
                        "0",
                        String.valueOf(item.getId()), replacedName,
                        "1"
                }
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction(out));
        new StartUI(0, out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() throws InterruptedException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(0, out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindById() throws InterruptedException {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("First item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction(out));
        new StartUI(0, out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu.0. === Find item by Id ====1. Exit1"
                        + "Menu.0. === Find item by Id ====1. Exit"
        ));
    }

    @Test
    public void whenFindByName() throws InterruptedException {
        Tracker tracker = new Tracker();
        String findName = "First item";
        Item item = tracker.add(new Item(findName));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getName()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(0, out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu.0. === Find items by name ===="
                        + "1. ExitFirst itemMenu.0. === Find items by name ====1. Exit"
        ));
    }

    @Test
    public void whenFindAll() throws InterruptedException {
        Tracker tracker = new Tracker();
        String[] itemsName = {"First item", "Second item"};
        tracker.add(new Item(itemsName[0]));
        tracker.add(new Item(itemsName[1]));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindAllAction(out));
        actions.add(new ExitAction(out));
        new StartUI(0, out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu.0. === Show all items ===="
                        + "1. ExitFirst itemSecond itemMenu."
                        + "0. === Show all items ====1. Exit"
        ));

    }

    @Test
    public void whenExit() throws InterruptedException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu." + "0. Exit"));
    }

    @Test
    public void whenInvalidExit() throws InterruptedException {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu."
                        + "0. Exit"
                        + "Wrong input, you can select: 0 .. 0"
                        + "Menu."
                        + "0. Exit"
        ));
    }
}