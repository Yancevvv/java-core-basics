package org.example.patterns.chainofresponsibility;

public class SMSMessageSender extends MessageSender {
    @Override
    protected boolean canHandle(PriorityLevel level) {
        return level.getWeight() >= PriorityLevel.HIGH.getWeight();
    }

    @Override
    protected void write(String message) {
        System.out.println("[SMS] Срочная отправка SMS менеджеру: " + message);
    }
}