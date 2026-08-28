package org.example.patterns.decorator;

public class DdosProtection extends ServerDecorator {
    public DdosProtection(ServerConfig server) {
        super(server);
    }

    @Override
    public double getMonthlyPrice() {
        return super.getMonthlyPrice() + 500.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + DDoS-защита L7";
    }
}