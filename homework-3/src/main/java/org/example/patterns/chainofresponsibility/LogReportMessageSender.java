package org.example.patterns.chainofresponsibility;

public class LogReportMessageSender extends MessageSender {
    @Override
    protected boolean canHandle(PriorityLevel level) {
        return level.getWeight() >= PriorityLevel.LOW.getWeight();
    }

    @Override
    protected void write(String message) {
        System.out.println("[LOG] Запись в лог-файл: " + message);
    }
}