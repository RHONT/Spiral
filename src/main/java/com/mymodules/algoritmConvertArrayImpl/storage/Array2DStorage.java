package com.mymodules.algoritmConvertArrayImpl.storage;

import java.util.Arrays;

/**
 * Обертка для массива. <br>
 * Хранит в себе базовую информацию о массиве: кол-во строк/колонок и сумму элементов
 */
public final class Array2DStorage {
    private final int _rows;
    private final int _column;
    private int _currentElements;
    private final int _totalElements;
    private final int[][] _array;

    public Array2DStorage(int rows, int columns) {
        _rows = rows;
        _column = columns;
        _currentElements = totalAmountElements();
        _totalElements =totalAmountElements();
        _array =new int[_rows][_column];
    }

    public int getRows() {
        return _rows;
    }

    public int getColumn() {
        return _column;
    }

    public int getSumElement() {
        return _currentElements;
    }

    public int[][] getArray() {
        return Arrays.copyOf(_array, _array.length);
    }

    public int[][] getArrayForOperation() {
        return _array;
    }

    public void reduceByOne(){
        _currentElements--;
    }

    private int totalAmountElements(){
        return _rows * _column;
    }

    public int get_total() {
        return _totalElements;
    }
}
