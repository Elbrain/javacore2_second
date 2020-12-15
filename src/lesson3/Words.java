package lesson3;

import java.util.*;

public class Words {
    static ArrayList<String> words = new ArrayList<>();
    static HashSet<String> uniqueWords = new HashSet<>();
    public static void main(String[] args) {
        words.add("Красный");
        words.add("Зеленый");
        words.add("Синий");
        words.add("Розовый");
        words.add("Черный");
        words.add("Красный");
        words.add("Белый");
        words.add("Белый");
        words.add("Синий");
        words.add("Красный");
        words.add("Синий");
        words.add("Синий");
        words.add("Малиновый");
        uniqueWords.addAll(words);
        System.out.println(" Все слова из массива - " + words);
        System.out.println(" Слова без учёта повторений - " + uniqueWords);
        System.out.println();
        for (String word : uniqueWords) {
            int howMany = 0;
            for (String s : words) {
                if (word.equals(s)){
                    howMany++;
                }
            }
            System.out.println("Слово " + word + " встречается " + howMany + " раз(а)");
        }
    }
}
