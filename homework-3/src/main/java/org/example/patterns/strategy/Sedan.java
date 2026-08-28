package org.example.patterns.strategy;

public class Sedan extends Auto {
    public Sedan() {
        super(new StandardFillStrategy());
    }
}