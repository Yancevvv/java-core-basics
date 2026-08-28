package org.example.patterns.decorator;

public class SsdStorage extends ServerDecorator {
    private final int sizeGb;

    public SsdStorage(ServerConfig server, int sizeGb) {
        super(server);
        this.sizeGb = sizeGb;
    }

    @Override
    public double getMonthlyPrice() {
        return super.getMonthlyPrice() + (sizeGb * 15.0);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + " + sizeGb + " ГБ NVMe SSD";
    }
}