package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingle3Test {

    @Test
    public void whenCreateTwoInstanceThenSameInstance() {
        TrackerSingle3 firstInstance = TrackerSingle3.getInstance();
        TrackerSingle3 secondInstance = TrackerSingle3.getInstance();
        assertEquals(firstInstance, secondInstance);
    }
}