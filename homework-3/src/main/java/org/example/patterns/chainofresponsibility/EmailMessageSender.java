package org.example.patterns.chainofresponsibility;

public class EmailMessageSender extends MessageSender {
    @Override
    protected boolean canHandle(PriorityLevel level) {
        return level.getWeight() >= PriorityLevel.MIDDLE.getWeight();
    }

    @Override
    protected void write(String message) {
        System.out.println("[EMAIL] Отправка Email: " + message);
    }
}