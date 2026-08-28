package org.example.patterns.decorator;

public abstract class ServerDecorator implements ServerConfig {
    protected final ServerConfig server;

    protected ServerDecorator(ServerConfig server) {
        this.server = server;
    }

    @Override
    public double getMonthlyPrice() {
        return server.getMonthlyPrice();
    }

    @Override
    public String getDescription() {
        return server.getDescription();
    }
}