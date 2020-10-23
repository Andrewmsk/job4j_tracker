package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingle1Test {

    @Test
    public void whenCreateTwoInstanceThenSameInstance() {
        TrackerSingle1 firstInstance = TrackerSingle1.getInstance();
        TrackerSingle1 secondInstance = TrackerSingle1.getInstance();
        assertEquals(firstInstance, secondInstance);
    }
}