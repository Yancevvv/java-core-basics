package org.example.patterns.proxy;

public class DisplayTimetable {
    private final TimetableTrains timetableTrains;

    public DisplayTimetable(TimetableTrains timetableTrains) {
        this.timetableTrains = timetableTrains;
    }

    public void printTimetable() {
        String[] timetable = timetableTrains.getTimetable();
        System.out.println("Поезд\tОткуда\tКуда\t\tВремя отправления\tВремя прибытия\tВремя в пути");
        System.out.println("------------------------------------------------------------------------");

        for (String record : timetable) {
            String[] parts = record.split(";");
            if (parts.length >= 6) {
                System.out.printf("%s\t%s\t%s\t\t%s\t\t\t\t%s\t\t\t%s\n",
                        parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
            }
        }
    }
}