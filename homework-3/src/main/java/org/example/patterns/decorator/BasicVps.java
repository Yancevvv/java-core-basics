package org.example.patterns.decorator;

public class BasicVps implements ServerConfig {
    private final String osName;
    private final double basePrice;

    public BasicVps(String osName, double basePrice) {
        this.osName = osName;
        this.basePrice = basePrice;
    }

    @Override
    public double getMonthlyPrice() {
        return basePrice;
    }

    @Override
    public String getDescription() {
        return "Базовый VPS (" + osName + ")";
    }
}