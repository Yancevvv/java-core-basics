package org.example.patterns.decorator;

public class RamUpgrade extends ServerDecorator {
    private final int gigabytes;
    private final double pricePerGb;

    public RamUpgrade(ServerConfig server, int gigabytes) {
        super(server);
        this.gigabytes = gigabytes;
        this.pricePerGb = 250.0;
    }

    @Override
    public double getMonthlyPrice() {
        return super.getMonthlyPrice() + (gigabytes * pricePerGb);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + " + gigabytes + " ГБ RAM";
    }
}