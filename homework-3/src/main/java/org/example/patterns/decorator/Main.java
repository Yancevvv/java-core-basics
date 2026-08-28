package org.example.patterns.decorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Паттерн Декоратор (Конфигуратор VPS) ===\n");

        ServerConfig basicLinux = new BasicVps("Ubuntu 22.04", 400.0);
        System.out.printf("Минимальная: %-60s = %.2f руб.%n",
                basicLinux.getDescription(), basicLinux.getMonthlyPrice());

        // Конфигурация для веб-сервера (добавляем RAM и SSD)
        ServerConfig webServer = new SsdStorage(
                new RamUpgrade(basicLinux, 4),
                50);
        System.out.printf("Веб-сервер:   %-60s = %.2f руб.%n",
                webServer.getDescription(), webServer.getMonthlyPrice());

        // Премиум конфигурация для базы данных (максимальный стек)
        ServerConfig dbServer = new DailyBackup(
                new DdosProtection(
                        new SsdStorage(
                                new RamUpgrade(new BasicVps("Debian 12", 500.0), 16),
                                200)));

        System.out.printf("База данных: %-60s = %.2f руб.%n",
                dbServer.getDescription(), dbServer.getMonthlyPrice());

        System.out.println("\n--- Демонстрация динамического изменения ---");
        // Мы можем взять базовый сервер и применить к нему разные декораторы независимо
        ServerConfig tempServer = new BasicVps("Windows Server", 800.0);
        System.out.println("До: " + tempServer.getDescription() + " (" + tempServer.getMonthlyPrice() + " руб.)");

        tempServer = new RamUpgrade(tempServer, 8);
        System.out.println("После апгрейда RAM: " + tempServer.getDescription() + " (" + tempServer.getMonthlyPrice() + " руб.)");
    }
}