package com.mymodules.algoritmConvertArrayImpl.storage;

import java.util.Arrays;

/**
 * Обертка для массива. <br>
 * Хранит в себе базовую информацию о массиве: кол-во строк/колонок и сумму элементов
 */
public final class Array2DStorage {
    private final int _rows;
    private final int _column;
    private final int _totalElements;
    private final int[][] _array;

    public Array2DStorage(int rows, int columns) {
        _rows = rows;
        _column = columns;
        _totalElements = totalAmountElements();
        _array =new int[_rows][_column];
    }

    public int getRows() {
        return _rows;
    }

    public int getColumn() {
        return _column;
    }

    public int getTotalElements() {
        return _totalElements;
    }

    public int[][] getDeepCopyArray() {
        return Arrays.copyOf(_array, _array.length);
    }

    public int[][] getRealArray() {
        return _array;
    }

    private int totalAmountElements(){
        return _rows * _column;
    }


}
