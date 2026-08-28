package org.example.patterns.strategy;

public class StandardFillStrategy implements FillStrategy {
    @Override
    public void fill() {
        System.out.println("Просто заправляем бензин!");
    }
}