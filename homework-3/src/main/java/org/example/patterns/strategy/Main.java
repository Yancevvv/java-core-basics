package org.example.patterns.strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Паттерн Стратегия ===\n");

        Auto sedan = new Sedan();
        Auto hybrid = new HybridAuto();
        Auto f1car = new F1Car();
        Auto buggies = new ChildrenBuggies();

        System.out.println("--- Стандартные стратегии ---");
        sedan.fill();
        hybrid.fill();
        f1car.fill();

        System.out.println("\n--- Игрушечный багги ---");
        buggies.fill();

        System.out.println("\n--- Меняем стратегию на ходу ---");
        buggies.setFillStrategy(new StandardFillStrategy());
        buggies.fill();

        System.out.println("\n--- Меняем стратегию для гибрида ---");
        hybrid.setFillStrategy(new StandardFillStrategy());
        hybrid.fill();
    }
}