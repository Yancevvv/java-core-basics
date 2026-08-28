package org.example.patterns.decorator;

public class DailyBackup extends ServerDecorator {
    public DailyBackup(ServerConfig server) {
        super(server);
    }

    @Override
    public double getMonthlyPrice() {
        return super.getMonthlyPrice() + 300.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Ежедневные бэкапы";
    }
}