package org.example.patterns.adapter;

public class SdCard {
    public void insertIntoSlot() {
        System.out.println("[SD-карта] Карта вставлена в слот адаптера.");
    }

    public String readFiles() {
        return "Фотографии_2026.jpg, Отчет.docx";
    }

    public void eject() {
        System.out.println("[SD-карта] Карта безопасно извлечена.");
    }
}