package org.example.patterns.proxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Паттерн Прокси (Кэширующий) ===\n");

        TimetableTrains proxy = new TimetableElectricTrainsProxy();
        DisplayTimetable display = new DisplayTimetable(proxy);

        System.out.println("--- 1. Первый вызов (загрузка с диска через прокси) ---");
        display.printTimetable();

        System.out.println("\n--- 2. Второй вызов (данные берутся из кэша прокси) ---");
        display.printTimetable();

        System.out.println("\n--- 3. Поиск конкретного поезда (использует кэш прокси) ---");
        String departure = proxy.getTrainDepartureTime("BA-1404");
        System.out.println("Результат поиска: " + departure);

        System.out.println("\n--- 4. Очистка кэша и повторная загрузка ---");
        ((TimetableElectricTrainsProxy) proxy).clearCache();
        display.printTimetable();
    }
}