package org.example.patterns.strategy;

public class ChildrenBuggies extends Auto {
    public ChildrenBuggies() {
        super(new NoFillStrategy());
    }
}
