package lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private static int count = 0;
    private HashMap<String, ArrayList<Person>> phoneBook = new HashMap<>();

    public void add(String surname, String number, String mail) {
        if (phoneBook.containsKey(surname)) {
            ArrayList<Person> personDetails = phoneBook.get(surname);
            personDetails.add(new Person(surname, number, mail));
        } else {
            ArrayList<Person> personDetails = new ArrayList<>();
            personDetails.add(new Person(surname, number, mail));
            phoneBook.put(surname, personDetails);
        }
        count++;
    }

    public void getPhone(String surname) {
        ArrayList<Person> personDetail = phoneBook.get(surname);
        for (int i = 0; i < personDetail.size(); i++) {
            System.out.println("Номер телефона - " + surname + " является - " + personDetail.get(i).phone);
        }
    }

    public void getEmail(String surname) {
        ArrayList<Person> personDetail = phoneBook.get(surname);
        for (int i = 0; i < personDetail.size(); i++) {
            System.out.println("Эмейл - " + surname + " является - " + personDetail.get(i).email);
        }
    }
}

/*
  Написать простой класс PhoneBook(внутри использовать HashMap):
    - В качестве ключа использовать фамилию
    - В каждой записи всего два поля: phone, e-mail
    - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
    и отдельный метод для поиска e-mail по фамилии.
    Следует учесть, что под одной фамилией может быть несколько записей. Итого должно получиться 3 класса Main, PhoneBook, Person.
*/
