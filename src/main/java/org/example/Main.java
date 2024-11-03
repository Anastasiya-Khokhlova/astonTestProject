package org.example;


import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList(
                "cat", "dog", "mouse", "cat", "bird", "dog", "horse", "mouse",
                "hamster", "bird", "cow", "dog", "mouse", "cat", "horse"
        ));
        System.out.println(WordsCount.listOfUniqueWords(words));
        System.out.println(WordsCount.listAndCountOfUniqueWords(words));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "12345");
        phoneBook.add("Петров", "23456");
        phoneBook.add("Косилов","34567");
        phoneBook.add("Иванов", "45678");
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Косилов"));
    }
}