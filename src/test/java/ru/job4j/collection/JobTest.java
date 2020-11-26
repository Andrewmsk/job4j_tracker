package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenCompatorByNameAsc() {
        Comparator<Job> jobComparator = new JobAscByName();
        int result = jobComparator.compare(
                new Job("Abc task", 0),
                new Job("Cde bug", 1)
        );
        assertTrue(result < 0);
    }

    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> jobComparator = new JobDescByName();
        int result = jobComparator.compare(
                new Job("Abc task", 0),
                new Job("Cde bug", 1)
        );
        assertTrue(result > 0);
    }

    @Test
    public void whenCompatorByPriorityAsc() {
        Comparator<Job> jobComparator = new JobAscByPriority();
        int result = jobComparator.compare(
                new Job("Abc task", 0),
                new Job("Cde bug", 1)
        );
        assertTrue(result < 0);
    }

    @Test
    public void whenCompatorByPriorityDesc() {
        Comparator<Job> jobComparator = new JobDescByPriority();
        int result = jobComparator.compare(
                new Job("Abc task", 0),
                new Job("Cde bug", 1)
        );
        assertTrue(result > 0);
    }

    @Test
    public void whenCompatorByNameAndProrityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(rsl > 0);
    }

    @Test
    public void whenCompatorByNameAndProrityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertTrue(rsl < 0);
    }

    @Test
    public void whenCompatorByNameAndProrityAscSameName() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertTrue(rsl < 0);
    }

    @Test
    public void whenCompatorByNameAndProrityDescSameName() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertTrue(rsl > 0);
    }
}