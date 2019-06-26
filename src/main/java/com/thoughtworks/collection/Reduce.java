package com.thoughtworks.collection;

import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        int maximum = arrayList.get(0);

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) > maximum) {
                maximum = arrayList.get(i);
            }
        }

        return maximum;
    }

    public double getMinimum() {
        int minimum = arrayList.get(0);

        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i) < minimum) {
                minimum = arrayList.get(i);
            }
        }

        return minimum;
    }

    public double getAverage() {
        return (double) arrayList.stream().reduce(0, Integer::sum) / arrayList.size();

    }

    public double getOrderedMedian() {
        int medianIndex = arrayList.size() / 2;
        if (arrayList.size() % 2 == 0) {
            return (double)(arrayList.get(medianIndex) + arrayList.get(medianIndex - 1)) / 2;
        }
        return (double)arrayList.get(medianIndex);
    }

    public int getFirstEven() {
        for (Integer integer : arrayList) {
            if (integer % 2 == 0) {
                return integer;
            }
        }
        return -1;
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (arrayList.size() != this.arrayList.size()) {
            return false;
        } else {
            for (int i = 0; i < this.arrayList.size(); i++) {
                if (arrayList.get(i) != arrayList.get(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public Double getMedianInLinkList(SingleLink<Integer> singleLink) {

        for (Integer integer : arrayList) {
            singleLink.addTailPointer(integer);
        }

        int medianIndex = arrayList.size() / 2;

        if (arrayList.size() % 2 == 0) {
            return (double)(singleLink.getNode(medianIndex) + singleLink.getNode(medianIndex + 1)) / 2;
        }
        return (double) singleLink.getNode(medianIndex + 1);

    }

    public int getLastOdd() {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) % 2 != 0) {
                return arrayList.get(i);
            }
        }
        return -1;

    }

    public int getIndexOfLastOdd() {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) % 2 != 0) {
                return i;
            }
        }
        return -1;
    }
}
