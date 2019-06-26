package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<>();

        for (Integer[] oneArray : array) {
            Collections.addAll(result, oneArray);
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        Flaten flaten = new Flaten(array);
        List<Integer> dimesionalArray = flaten.transformToOneDimesional();

        Filter filter = new Filter(dimesionalArray);
        return filter.getDifferentElements();
    }
}
