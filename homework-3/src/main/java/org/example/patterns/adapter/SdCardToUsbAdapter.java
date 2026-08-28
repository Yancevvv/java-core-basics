package org.example.patterns.adapter;

public class SdCardToUsbAdapter implements UsbDevice {
    private final SdCard sdCard;

    public SdCardToUsbAdapter(SdCard sdCard) {
        this.sdCard = sdCard;
    }

    @Override
    public void connect() {
        System.out.println("[Адаптер] Преобразование USB-сигнала в формат SD-карты...");
        sdCard.insertIntoSlot();
    }

    @Override
    public String readData() {
        System.out.println("[Адаптер] Чтение данных с SD-карты через USB-протокол...");
        return sdCard.readFiles();
    }

    @Override
    public void disconnect() {
        System.out.println("[Адаптер] Завершение USB-сессии...");
        sdCard.eject();
    }
}