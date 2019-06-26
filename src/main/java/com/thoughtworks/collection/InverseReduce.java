package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {

        List<Integer> result = new ArrayList<>();

        int randomNumber = random.nextInt(3);
        int i = number - randomNumber;
        while(i >=0){
            result.add(i);
            i = i - randomNumber;
        }
        return  result;
    }
}
