package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < left.length(); i++) {
            if (right.length() - 1 < i) {
                return 1;
            }
            int result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        if (left.length() < right.length()) {
            return -1;
        }
        return 0;
    }
}
