package org.example.patterns.adapter;

public class Computer {
    public void transferDataFrom(UsbDevice usbDevice) {
        System.out.println("--- Компьютер начинает работу с устройством ---");
        usbDevice.connect();

        String data = usbDevice.readData();
        System.out.println("Компьютер успешно получил данные: " + data);

        usbDevice.disconnect();
        System.out.println("--- Сеанс завершен ---\n");
    }
}