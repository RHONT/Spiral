package com.mymodules.algoritmConvertArrayImpl;

import com.mymodules.algoritmConvertArrayImpl.storage.Array2DStorage;
/**
 * Класс для алгоритмов по закручиванию в спираль массивов<br>
 * storage -> Обёртка для int[][]<br>
 * generateArray - начать генерацию массива<br>
 * getArray - возвращает сгенерированный массив из {@link Array2DStorage}<br>
 * createStorage - создаем хранилище для результата алгоритма
 */
public abstract class AlgorithmGenerateArray {
    protected Array2DStorage _storage;

    public AlgorithmGenerateArray() {
    }

    public abstract int[][] generateArray();

    public int[][] getDeepCopyArray(){
        return _storage.getDeepCopyArray();
    }

    public void createStorage(int rows, int columns){
        this._storage = new Array2DStorage(rows,columns);
    }



}
