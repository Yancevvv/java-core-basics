package org.example;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {
    private static final Lock RESOURCE_A = new ReentrantLock();
    private static final Lock RESOURCE_B = new ReentrantLock();

    public static void main(String[] args) {
        Thread worker1 = new Thread(() -> {
            int attempts = 0;
            while (attempts < 100) { // Ограничитель, чтобы программа завершилась и мы увидели результат
                if (RESOURCE_A.tryLock()) {
                    try {
                        System.out.println("Worker 1: Захватил RESOURCE_A");
                        Thread.sleep(50); // Имитация работы перед запросом второго ресурса

                        System.out.println("Worker 1: Пытается захватить RESOURCE_B...");
                        if (RESOURCE_B.tryLock()) {
                            try {
                                System.out.println("Worker 1: Успешно захватил оба ресурса! Работа выполнена.");
                                return;
                            } finally {
                                RESOURCE_B.unlock();
                            }
                        } else {
                            System.out.println("Worker 1: Не смог захватить RESOURCE_B, освобождает RESOURCE_A и пробует снова.");
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        RESOURCE_A.unlock();
                    }
                }
                attempts++;
                // Небольшая пауза, чтобы не перегружать процессор в цикле
                try { Thread.sleep(10); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
            System.out.println("Worker 1: Превышено количество попыток. Это LiveLock (потоки активны, но прогресса нет).");
        });

        Thread worker2 = new Thread(() -> {
            int attempts = 0;
            while (attempts < 100) {
                if (RESOURCE_B.tryLock()) {
                    try {
                        System.out.println("Worker 2: Захватил RESOURCE_B");
                        Thread.sleep(50);

                        System.out.println("Worker 2: Пытается захватить RESOURCE_A...");
                        if (RESOURCE_A.tryLock()) {
                            try {
                                System.out.println("Worker 2: Успешно захватил оба ресурса! Работа выполнена.");
                                return;
                            } finally {
                                RESOURCE_A.unlock();
                            }
                        } else {
                            System.out.println("Worker 2: Не смог захватить RESOURCE_A, освобождает RESOURCE_B и пробует снова.");
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        RESOURCE_B.unlock();
                    }
                }
                attempts++;
                try { Thread.sleep(10); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
            System.out.println("Worker 2: Превышено количество попыток. Это LiveLock (потоки активны, но прогресса нет).");
        });

        worker1.start();
        worker2.start();
    }
}