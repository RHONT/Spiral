package com.mymodules.algoritmConvertArrayImpl;

import com.mymodules.storage.ArrayStorage;
/**
 * Класс для алгоритмов по закручиванию в спираль массивов<br>
 * storage -> Обёртка для int[][]<br>
 * generateArray - начать генерацию массива<br>
 * getArray - возвращает сгенерированный массив из {@link ArrayStorage}<br>
 */
public abstract class AlgorithmGenerateArray {
    protected ArrayStorage storage;

    public AlgorithmGenerateArray(int rows, int columns) {
        this.storage = new ArrayStorage(rows,columns);
    }

    public abstract int[][] generateArray();

    public int[][] getArray(){
        return storage.getArray();
    }

}
