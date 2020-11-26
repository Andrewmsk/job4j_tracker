package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        if (!left.contains(".") && !right.contains(".")) {
            return left.compareTo(right);
        }
        return Integer.valueOf(left.split("\\.")[0])
                .compareTo(Integer.valueOf(right.split("\\.")[0]));
    }
}
