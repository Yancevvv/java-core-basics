package org.example.patterns.adapter;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Паттерн Адаптер ===\n");

        SdCard mySdCard = new SdCard();

        UsbDevice usbAdapter = new SdCardToUsbAdapter(mySdCard);

        Computer myComputer = new Computer();
        myComputer.transferDataFrom(usbAdapter);
    }
}