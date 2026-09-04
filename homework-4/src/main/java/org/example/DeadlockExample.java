package org.example;

public class DeadlockExample {
    private static final Object RESOURCE_1 = new Object();
    private static final Object RESOURCE_2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (RESOURCE_1) {
                System.out.println("Поток 1: Захватил RESOURCE_1");
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

                System.out.println("Поток 1: Ожидает RESOURCE_2...");
                synchronized (RESOURCE_2) {
                    System.out.println("Поток 1: Захватил RESOURCE_2");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (RESOURCE_2) {
                System.out.println("Поток 2: Захватил RESOURCE_2");
                try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

                System.out.println("Поток 2: Ожидает RESOURCE_1...");
                synchronized (RESOURCE_1) {
                    System.out.println("Поток 2: Захватил RESOURCE_1");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}