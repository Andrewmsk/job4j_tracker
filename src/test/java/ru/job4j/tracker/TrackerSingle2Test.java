package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingle2Test {

    @Test
    public void whenCreateTwoInstanceThenSameInstance() {
        TrackerSingle2 firstInstance = TrackerSingle2.getInstance();
        TrackerSingle2 secondInstance = TrackerSingle2.getInstance();
        assertEquals(firstInstance, secondInstance);
    }
}