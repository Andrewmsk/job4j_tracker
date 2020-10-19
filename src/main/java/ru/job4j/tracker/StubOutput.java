package ru.job4j.tracker;

public class StubOutput implements Output {

    private final StringBuilder builder = new StringBuilder();

    @Override
    public void println(Object object) {
        if (object != null) {
            builder.append(object);
        } else {
            builder.append("null");
        }
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
