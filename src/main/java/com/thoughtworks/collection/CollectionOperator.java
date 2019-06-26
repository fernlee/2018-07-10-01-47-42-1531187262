package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int i = left;
        List<Integer> list = new ArrayList<>();
        if (left < right) {
            for (; i <= right; i++) {
                list.add(i);
            }
        } else {
            for (; i >= right; i--) {
                list.add(i);
            }
        }
        return list;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int i = left;
        ArrayList<Integer> list = new ArrayList<>();
        if (left < right) {
            for (; i <= right; i++) {
                if (i % 2 == 0) {
                    list.add(i);
                }
            }
        } else {
            for (; i >= right; i--) {
                if (i % 2 == 0) {
                    list.add(i);
                }
            }
        }
        return list;
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(v -> v % 2 == 0).collect(toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> list = new ArrayList<>();
        for (int firstArrayElement : firstArray) {
            for (int secondArrayElement : secondArray) {
                if (firstArrayElement == secondArrayElement) {
                    list.add(firstArrayElement);
                }
            }
        }
        return list;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> list = new ArrayList<>(Arrays.asList(firstArray));
        for (int secondArrayElement : secondArray) {
            int count = 0;
            for (int firstArrayElement : firstArray) {
                if (firstArrayElement != secondArrayElement) {
                    count++;
                }
                if (count == firstArray.length) {
                    list.add(secondArrayElement);
                }
            }
        }
        return list;
    }
}
