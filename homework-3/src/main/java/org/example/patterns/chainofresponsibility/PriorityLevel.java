package org.example.patterns.chainofresponsibility;

public enum PriorityLevel {
    LOW(1),
    MIDDLE(2),
    HIGH(3);

    private final int weight;

    PriorityLevel(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}