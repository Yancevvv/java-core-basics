package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== ЗАПУСК ВСЕХ ПАТТЕРНОВ ==========\n");

        System.out.println("1. СТРАТЕГИЯ");
        org.example.patterns.strategy.Main.main(args);

        System.out.println("\n\n2. ЦЕПОЧКА ОТВЕТСТВЕННОСТИ");
        org.example.patterns.chainofresponsibility.BugEvent.main(args);

        System.out.println("\n\n3. БИЛДЕР");
        org.example.patterns.builder.Main.main(args);

        System.out.println("\n\n4. ПРОКСИ");
        org.example.patterns.proxy.Main.main(args);

        System.out.println("\n\n5. ДЕКОРАТОР");
        org.example.patterns.decorator.Main.main(args);

        System.out.println("\n\n6. АДАПТЕР");
        org.example.patterns.adapter.Main.main(args);
    }
}