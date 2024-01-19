package algoritmConvertArrayImpl;

import storage.ArrayStorage;
/**
 * Класс для алгоритмов по закручиванию в спираль массивов
 * storage -> Обёртка для int[][]
 * Example:
 * generateArray(3,3) - >
 *  1 2 3
 *  8 9 4
 *  7 6 5
 *
 *
 */
public abstract class AlgorithmBase {
    protected ArrayStorage storage;

    public AlgorithmBase(int rows, int columns) {
        this.storage = new ArrayStorage(rows,columns);
    }

    public abstract int[][] generateArray();
    public abstract int[][] getSpiralArray();

}
