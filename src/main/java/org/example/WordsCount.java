package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class WordsCount {
    public WordsCount() {

    }

    public static HashSet<String> listOfUniqueWords(ArrayList<String> words) {
        HashSet<String> uniqueList = new HashSet<>(words);
        return uniqueList;
    }

    public static HashMap<String, Integer> listAndCountOfUniqueWords(ArrayList<String> words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int wordCount = 0;
            for (int j = 0; j < words.size(); j++) {
                if (words.get(j).equals(word)) {
                    wordCount++;
                }
            }
            hashMap.put(word, wordCount);
        }
        return hashMap;
    }




}
