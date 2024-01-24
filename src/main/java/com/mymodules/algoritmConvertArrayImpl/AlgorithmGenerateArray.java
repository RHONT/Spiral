package com.mymodules.algoritmConvertArrayImpl;

import com.mymodules.algoritmConvertArrayImpl.storage.ArrayStorage;
/**
 * Класс для алгоритмов по закручиванию в спираль массивов<br>
 * storage -> Обёртка для int[][]<br>
 * generateArray - начать генерацию массива<br>
 * getArray - возвращает сгенерированный массив из {@link ArrayStorage}<br>
 * createStorage - создаем хранилище для результата алгоритма
 */
public abstract class AlgorithmGenerateArray {
    protected ArrayStorage _storage;

    public AlgorithmGenerateArray() {
    }

    public abstract int[][] generateArray();

    public int[][] getArray(){
        return _storage.getArray();
    }

    public void createStorage(int rows, int columns){
        this._storage = new ArrayStorage(rows,columns);
    }



}
