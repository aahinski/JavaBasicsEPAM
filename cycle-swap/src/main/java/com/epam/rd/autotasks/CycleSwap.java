package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        cycleSwap(array, 1);
    }

    static void cycleSwap(int[] array, int shift) {
        int len = array.length;
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            int newPosition = (i + shift) % len;
            newArray[newPosition] = array[i];
        }
        System.out.println(newArray.toString());
    }
}
