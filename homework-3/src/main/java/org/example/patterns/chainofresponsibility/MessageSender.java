package org.example.patterns.chainofresponsibility;

public abstract class MessageSender {
    private MessageSender nextSender;

    public MessageSender setNextSender(MessageSender nextSender) {
        this.nextSender = nextSender;
        return this;
    }

    public void handleMessage(String message, PriorityLevel level) {
        if (canHandle(level)) {
            write(message);
            return;
        }

        if (nextSender != null) {
            nextSender.handleMessage(message, level);
        } else {
            System.out.println("Сообщение не было обработано: " + message);
        }
    }

    protected abstract boolean canHandle(PriorityLevel level);

    protected abstract void write(String message);
}