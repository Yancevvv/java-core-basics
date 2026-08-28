package org.example.patterns.strategy;

public class HybridAuto extends Auto {
    public HybridAuto() {
        super(new HybridFillStrategy());
    }
}