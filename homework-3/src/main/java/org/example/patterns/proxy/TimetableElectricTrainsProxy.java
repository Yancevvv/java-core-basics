package org.example.patterns.proxy;

public class TimetableElectricTrainsProxy implements TimetableTrains {
    private final TimetableTrains realSubject;

    private String[] timetableCache;
    private long cacheTimestamp;
    private static final long CACHE_DURATION = 24 * 60 * 60 * 1000; // 24 часа

    public TimetableElectricTrainsProxy() {
        this.realSubject = new TimetableElectricTrains();
    }

    @Override
    public synchronized String[] getTimetable() {
        if (isCacheValid()) {
            System.out.println("[Proxy] Возврат данных из кэша.");
            return timetableCache;
        }

        System.out.println("[Proxy] Кэш устарел или пуст. Делегирование запроса реальном субъекту...");
        this.timetableCache = realSubject.getTimetable();
        this.cacheTimestamp = System.currentTimeMillis();
        return this.timetableCache;
    }

    @Override
    public String getTrainDepartureTime(String trainId) {
        return TimetableTrains.super.getTrainDepartureTime(getTimetable(), trainId);
    }

    private boolean isCacheValid() {
        return timetableCache != null && (System.currentTimeMillis() - cacheTimestamp) < CACHE_DURATION;
    }

    public synchronized void clearCache() {
        this.timetableCache = null;
        System.out.println("[Proxy] Кэш очищен.");
    }
}