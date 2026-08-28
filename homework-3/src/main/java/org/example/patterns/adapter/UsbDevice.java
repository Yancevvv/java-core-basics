package org.example.patterns.adapter;

public interface UsbDevice {
    void connect();
    String readData();
    void disconnect();
}