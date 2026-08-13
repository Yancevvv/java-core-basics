package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Изменяемый класс, который будет использоваться внутри иммутабельного класса
 */
public class MutableClass {
    private String name;
    private int value;
    private List<String> items;

    public MutableClass(String name, int value) {
        this.name = name;
        this.value = value;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public List<String> getItems() {
        return items;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void addItem(String item) {
        this.items.add(item);
    }

    public void removeItem(String item) {
        this.items.remove(item);
    }

    @Override
    public String toString() {
        return "MutableClass{name='" + name + "', value=" + value + ", items=" + items + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutableClass that = (MutableClass) o;
        return value == that.value &&
                Objects.equals(name, that.name) &&
                Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, items);
    }
}