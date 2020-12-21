package lesson3;

public class Main {
    public static void main(String[] args) {
        Phonebook book = new Phonebook();
        book.add("Ivanov","21313 ", "mail@123");
        book.add("Smirnov","2132122", "mail@123");
        book.add("Sidorov","21313", "mail@123");
        book.add("Mironov","343332", "mail@123");
        book.add("Sidorov", "2343", "mail@123");
        book.getPhone("Sidorov");
        book.getEmail("Mironov");
    }
}
