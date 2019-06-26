package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> tripleList = new ArrayList<>();

        for (Integer integer : array) {
            tripleList.add(integer * 3);
        }
        return tripleList;
    }

    public List<String> mapLetter() {
        List<String> letterList = new ArrayList<>();

        for (int i = 1; i <= array.size() && i <= letters.length; i++) {
            letterList.add(letters[i - 1]);
        }
        return letterList;

    }

    public List<String> mapLetters() {
        List<String> letterList = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            Integer number = array.get(i);
            int index = number - 1;
            if (number <= letters.length) {
                letterList.add(letters[index]);
            } else {
                int higherIndex = index / letters.length;
                letterList.add(letters[higherIndex - 1] + letters[index % letters.length]);
            }

        }
        return letterList;
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());

    }
}
