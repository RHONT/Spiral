package com.mymodules.storage;

import java.util.Arrays;

/**
 * Обертка для массива. <br>
 * Хранит в себе базовую информацию о массиве: кол-во строк/колонок и сумму элементов
 */
public final class ArrayStorage {
    private final int rows;
    private final int column;
    private int sumElement;
    private final int[][] array;

    public ArrayStorage(int rows, int columns) {
        this.rows = rows;
        this.column = columns;
        this.sumElement = rows*column;
        this.array =new int[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumn() {
        return column;
    }

    public int getSumElement() {
        return sumElement;
    }

    public int[][] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void reduceByOne(){
        sumElement--;
    }
}
