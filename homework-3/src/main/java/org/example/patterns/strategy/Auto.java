package org.example.patterns.strategy;

public abstract class Auto {
    private FillStrategy fillStrategy;
    protected Auto(FillStrategy fillStrategy) {
        this.fillStrategy = fillStrategy;
    }
    public void fill() {
        fillStrategy.fill();
    }

    public void gas() {
        System.out.println("Едем вперед");
    }

    public void stop() {
        System.out.println("Тормозим!");
    }

    public void setFillStrategy(FillStrategy fillStrategy) {
        this.fillStrategy = fillStrategy;
    }
}