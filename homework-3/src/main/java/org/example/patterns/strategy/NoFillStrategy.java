package org.example.patterns.strategy;

public class NoFillStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Этот транспорт не требует заправки (игрушечный).");
    }
}
