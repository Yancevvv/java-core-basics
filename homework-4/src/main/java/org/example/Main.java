package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите пример для запуска (или 0 для выхода):");
            System.out.println("1 - DeadLock");
            System.out.println("2 - LiveLock");
            System.out.println("3 - Sequential Printing (1 и 2 по очереди, бесконечно)");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Завершение работы.");
                    scanner.close();
                    return;
                case 1:
                    System.out.println("--- Запуск Deadlock (программа зависнет, это ожидаемо) ---");
                    DeadlockExample.main(args);
                    break;
                case 2:
                    System.out.println("--- Запуск Livelock ---");
                    LivelockExample.main(args);
                    break;
                case 3:
                    System.out.println("--- Запуск Sequential Printing (нажмите Ctrl+C или кнопку Stop в IDE для остановки) ---");
                    SequentialPrinting.main(args);
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }
}