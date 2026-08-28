package org.example.patterns.proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TimetableElectricTrains implements TimetableTrains {
    @Override
    public String[] getTimetable() {
        System.out.println("[RealSubject] Загрузка расписания с диска...");
        ArrayList<String> list = new ArrayList<>();
        try (InputStream is = getClass().getResourceAsStream("/trains.csv")) {
            if (is == null) {
                System.out.println("[RealSubject] Файл не найден, используем тестовые данные.");
                return getTestData();
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("[RealSubject] Ошибка чтения файла: " + e.getMessage());
            return getTestData();
        }
        return list.toArray(new String[0]);
    }

    private String[] getTestData() {
        return new String[]{
                "9B-6854;Лондон;Прага;13:43;21:15;07:32",
                "BA-1404;Париж;Грац;14:25;21:25;07:00",
                "9B-8710;Прага;Вена;04:48;08:49;04:01"
        };
    }
}