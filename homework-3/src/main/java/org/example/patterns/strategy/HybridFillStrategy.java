package org.example.patterns.strategy;

public class HybridFillStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Заправляем бензином или электричеством на выбор!");
    }
}