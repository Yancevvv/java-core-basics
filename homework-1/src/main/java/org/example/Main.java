package org.example;

import java.util.List;

/**
 * Демонстрация работы иммутабельного класса
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Демонстрация иммутабельного класса ===\n");

        MutableClass mutable = new MutableClass("Original", 100);
        mutable.addItem("Item1");
        mutable.addItem("Item2");
        System.out.println("Исходный изменяемый объект: " + mutable);

        ImmutableClass immutable = new ImmutableClass("ID-001", mutable);
        System.out.println("Иммутабельный объект: " + immutable);

        System.out.println("\n--- Изменяем исходный объект ---");
        mutable.setName("Changed");
        mutable.setValue(999);
        mutable.addItem("Item3");
        System.out.println("Измененный mutable: " + mutable);
        System.out.println("Иммутабельный объект после изменения mutable: " + immutable);
        System.out.println("Иммутабельный объект не изменился!");

        System.out.println("\n--- Попытка изменить через геттер ---");
        MutableClass retrieved = immutable.getMutableField();
        retrieved.setName("Hacked");
        retrieved.setValue(666);
        System.out.println("Измененная копия из геттера: " + retrieved);
        System.out.println("Оригинальный иммутабельный объект: " + immutable);
        System.out.println("Иммутабельный объект защищен от изменений через геттер!");

        System.out.println("\n--- Создание нового объекта с изменениями ---");
        MutableClass newMutable = new MutableClass("New Value", 777);
        newMutable.addItem("NewItem1");
        ImmutableClass newImmutable = immutable.withMutableField(newMutable);
        System.out.println("Новый иммутабельный объект: " + newImmutable);
        System.out.println("Старый иммутабельный объект: " + immutable);

        System.out.println("\n--- Работа с неизменяемым списком ---");
        List<String> list = immutable.getImmutableList();
        System.out.println("Список: " + list);

        try {
            list.add("Should fail");
        } catch (UnsupportedOperationException e) {
            System.out.println("Попытка изменить список вызвала исключение (как и ожидалось)");
        }

        System.out.println("\n=== Демонстрация завершена ===");
    }
}