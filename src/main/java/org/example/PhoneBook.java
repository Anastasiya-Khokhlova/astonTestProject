package org.example;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    public HashMap<String, HashSet<String>> phoneBook;


    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        HashSet<String> phones = phoneBook.get(lastName);
        if (phones == null) {
            phones = new HashSet<>();
            phones.add(phoneNumber);
            phoneBook.put(lastName, phones);
        } else {
            phones.add(phoneNumber);
            phoneBook.put(lastName, phones);
        }
    }

    public HashSet<String> get(String lastName) {
        HashSet<String> phones = phoneBook.get(lastName);
        return phones;
    }
}
