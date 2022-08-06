package com.epam.rd.autotasks;

import java.util.*;

public class CarouselRun {

    private int[] numbers;
    private int currentNumber;
    private int numberOfZeros;
    protected boolean isNumbersAdded;

    public CarouselRun(int n) {
        numbers = new int[n];
        Arrays.fill(numbers, -1);
        numbers[0] = 0;
        currentNumber = 0;
        isNumbersAdded = false;
        numberOfZeros = numbers.length;
    }

    public int next() {
       if(numberOfZeros == numbers.length) {
           return -1;
       } else {
           int i = currentNumber;
           while(numbers[i] <= 0)
               i = (i + 1) % numbers.length;
           int current = numbers[i];
           if(current == 1) {
               numberOfZeros++;
               numbers[i] = -1;
           }
           else
               numbers[i]--;
           currentNumber = (i + 1) % numbers.length;
           return current;
       }
    }

    public boolean isFinished() {
        int[] minusOnes = new int[numbers.length];
        Arrays.fill(minusOnes, -1);
        if(Arrays.equals(numbers, minusOnes) || !isNumbersAdded)
            return true;
        else
            return false;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int getNumberOfZeros() {
        return numberOfZeros;
    }

    public void setNumberOfZeros(int numberOfZeros) {
        this.numberOfZeros = numberOfZeros;
    }
}
