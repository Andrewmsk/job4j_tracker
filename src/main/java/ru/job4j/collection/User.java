package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {

    private String name;
    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        int result = this.name.compareTo(o.name);
        return result == 0 ? this.age.compareTo(o.age) : result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age.equals(user.age) &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
