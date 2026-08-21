package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Book> books1 = Arrays.asList(
                    new Book("Война и мир", "Толстой Л.Н.", 1274, 1869),
                    new Book("Преступление и наказание", "Достоевский Ф.М.", 672, 1866),
                    new Book("Анна Каренина", "Толстой Л.Н.", 864, 1877),
                    new Book("Мастер и Маргарита", "Булгаков М.А.", 384, 1967),
                    new Book("Тихий Дон", "Шолохов М.А.", 1472, 1928)
            );
            List<Book> books2 = Arrays.asList(
                    new Book("Гарри Поттер и философский камень", "Роулинг Дж.К.", 432, 2001),
                    new Book("Гарри Поттер и Тайная комната", "Роулинг Дж.К.", 512, 2002),
                    new Book("Гарри Поттер и узник Азкабана", "Роулинг Дж.К.", 480, 2004),
                    new Book("Гарри Поттер и Кубок огня", "Роулинг Дж.К.", 736, 2005),
                    new Book("Гарри Поттер и Орден Феникса", "Роулинг Дж.К.", 912, 2007)
            );
            List<Book> books3 = Arrays.asList(
                    new Book("Алхимик", "Коэльо П.", 208, 2008),
                    new Book("1984", "Оруэлл Дж.", 328, 1949),
                    new Book("Убить пересмешника", "Ли Х.", 384, 1960),
                    new Book("Властелин колец", "Толкин Дж.Р.Р.", 1216, 2002),
                    new Book("Маленький принц", "Сент-Экзюпери А.", 96, 1943)
            );

            List<Student> studentsToSave = Arrays.asList(
                    new Student("Иван Иванов", 20, books1),
                    new Student("Петр Петров", 22, books2),
                    new Student("Сергей Сергеев", 21, books3)
            );

            ObjectMapper writeMapper = new ObjectMapper();
            writeMapper.enable(SerializationFeature.INDENT_OUTPUT);
            writeMapper.writeValue(new File("students.json"), studentsToSave);

            new ObjectMapper()
                    .readValue(new File("students.json"), new TypeReference<List<Student>>() {})
                    .stream()
                    .peek(System.out::println)
                    .flatMap(student -> student.getBooks().stream())
                    .filter(book -> book.getYear() > 2000)
                    .distinct()
                    .sorted(Comparator.comparingInt(Book::getPages))
                    .limit(3)
                    .map(Book::getYear)
                    .findFirst()
                    .ifPresentOrElse(
                            year -> System.out.println("Найден год выпуска книги: " + year),
                            () -> System.out.println("Такая книга отсутствует")
                    );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}