package org.example.patterns.chainofresponsibility;

public class BugEvent {
    public static void main(String[] args) {
        System.out.println("=== Паттерн Цепочка ответственности ===\n");

        MessageSender logSender = new LogReportMessageSender();
        MessageSender emailSender = new EmailMessageSender();
        MessageSender smsSender = new SMSMessageSender();

        logSender.setNextSender(emailSender).setNextSender(smsSender);

        System.out.println("--- Сообщение уровня LOW ---");
        logSender.handleMessage("Незначительное предупреждение", PriorityLevel.LOW);

        System.out.println("\n--- Сообщение уровня MIDDLE ---");
        logSender.handleMessage("Ошибка валидации данных", PriorityLevel.MIDDLE);

        System.out.println("\n--- Сообщение уровня HIGH ---");
        logSender.handleMessage("КРИТИЧЕСКИЙ СБОЙ СИСТЕМЫ!", PriorityLevel.HIGH);

        System.out.println("\n--- Сообщение неизвестного/низкого уровня (для проверки конца цепи) ---");
    }
}