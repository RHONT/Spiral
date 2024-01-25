package com.mymodules.algoritmConvertArrayImpl;

/**
 * Example:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
public class ClassicAlgorithm extends AlgorithmGenerateArray {

    @Override
    public int[][] generateArray() {
        int incr=1;
        int[][] array= _storage.getDeepCopyArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j]=incr++;
            }
        }
        return array;
    }
}
