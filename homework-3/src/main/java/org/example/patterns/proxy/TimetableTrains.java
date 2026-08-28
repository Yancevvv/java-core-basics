package org.example.patterns.proxy;

public interface TimetableTrains {
    String[] getTimetable();

    default String getTrainDepartureTime(String[] timetableData, String trainId) {
        if (timetableData == null) return "Поезд не найден";
        for (String record : timetableData) {
            if (record.startsWith(trainId + ";")) {
                return record;
            }
        }
        return "Поезд не найден";
    }

    default String getTrainDepartureTime(String trainId) {
        return getTrainDepartureTime(getTimetable(), trainId);
    }
}