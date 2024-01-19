package storage;

import java.util.Arrays;

public final class ArrayStorage {
    private final int rows;
    private final int column;
    private int sumElement;
    private final int[][] spiralArray;

    public ArrayStorage(int rows, int columns) {
        this.rows = rows;
        this.column = columns;
        this.sumElement = rows*column;
        this.spiralArray=new int[rows][columns];
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

    public int[][] getSpiralArray() {
        return Arrays.copyOf(spiralArray,spiralArray.length);
    }

    public void reduceByOne(){
        sumElement--;
    }
}
