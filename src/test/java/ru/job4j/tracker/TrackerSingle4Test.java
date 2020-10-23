package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrackerSingle4Test {

    @Test
    public void whenCreateTwoInstanceThenSameInstance() {
        TrackerSingle4 firstInstance = TrackerSingle4.INSTANCE;
        TrackerSingle4 secondInstance = TrackerSingle4.INSTANCE;
        assertEquals(firstInstance.getValue(), secondInstance.getValue(), 0.01);
    }
}