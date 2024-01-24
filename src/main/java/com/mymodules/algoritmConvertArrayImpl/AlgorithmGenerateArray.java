package com.mymodules.algoritmConvertArrayImpl;

import com.mymodules.algoritmConvertArrayImpl.storage.ArrayStorage;
/**
 * Класс для алгоритмов по закручиванию в спираль массивов<br>
 * storage -> Обёртка для int[][]<br>
 * generateArray - начать генерацию массива<br>
 * getArray - возвращает сгенерированный массив из {@link ArrayStorage}<br>
 */
public abstract class AlgorithmGenerateArray {
    protected ArrayStorage storage;

    public AlgorithmGenerateArray() {
    }

    public abstract int[][] generateArray();

    public int[][] getArray(){
        return storage.getArray();
    }

    public void createStorage(int rows, int columns){
        this.storage = new ArrayStorage(rows,columns);
    }



}
