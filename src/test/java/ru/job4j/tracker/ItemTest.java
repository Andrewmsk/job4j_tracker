package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenDirectOrder() {
        List<Item> items = Arrays.asList(
                new Item("Steve"),
                new Item("Andrew"),
                new Item("Peter"));
        List<Item> expectedItems = Arrays.asList(
                new Item("Andrew"),
                new Item("Peter"),
                new Item("Steve"));
        Collections.sort(items);
        assertEquals(items, expectedItems);
    }

    @Test
    public void whenReverseOrder() {
        List<Item> items = Arrays.asList(
                new Item("Steve"),
                new Item("Andrew"),
                new Item("Peter"));
        List<Item> expectedItems = Arrays.asList(
                new Item("Steve"),
                new Item("Peter"),
                new Item("Andrew"));
        items.sort(Comparator.reverseOrder());
        assertEquals(items, expectedItems);
    }

    @Test
    public void whenCompareReverse() {
        Item firstItem = new Item("Andrew");
        Item secondItem = new Item("Steve");
        Comparator<Item> itemComparator = new ItemDescByName();
        assertTrue(itemComparator.compare(firstItem, secondItem) > 0);
    }
}