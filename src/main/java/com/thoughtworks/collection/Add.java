package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Add {

    private int getSumWithFilterFn(int leftBorder, int rightBorder, IntPredicate filterFn) {
        int start = leftBorder;
        int end = rightBorder;
        if (leftBorder > rightBorder) {
            start = rightBorder;
            end = leftBorder;
        }
        return IntStream.rangeClosed(start, end).filter(filterFn).reduce(0, Integer::sum);
    }

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        return getSumWithFilterFn(leftBorder, rightBorder, v -> v % 2 == 0);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        return getSumWithFilterFn(leftBorder, rightBorder, v -> v % 2 == 1);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(v -> v * 3 + 2).reduce(0, Integer::sum);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(v -> v % 2 == 1 ? v * 3 + 2 : v)
                .collect(toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(v -> v % 2 == 1).map(v -> v * 3 + 5).reduce(0, Integer::sum);
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size()-1; i++) {
            result.add((arrayList.get(i) + arrayList.get(i+1)) * 3);
        }
        return result;

    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> evenArray = arrayList.stream().filter(v -> v % 2 == 0).sorted().collect(toList());
        int medianIndex = evenArray.size() / 2;
        if (evenArray.size() % 2 == 0) {
            return (evenArray.get(medianIndex) + evenArray.get(medianIndex-1))/2 ;
        }
        return evenArray.get(medianIndex);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(v1 -> v1 % 2 == 0).reduce(0, Integer::sum) / arrayList.stream().filter(v1 -> v1 % 2 == 0).collect(toList()).size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(v -> v % 2 == 0 && v.equals(specialElment)).collect(toList()).size() != 0;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().distinct().filter(v -> v % 2 == 0).collect(toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = arrayList.stream().filter(v -> v % 2 == 0).sorted().collect(toList());
        List<Integer> oddList = arrayList.stream().filter(v -> v % 2 == 1).sorted(Comparator.reverseOrder()).collect(toList());
        evenList.addAll(oddList);
        return evenList;
    }
}
