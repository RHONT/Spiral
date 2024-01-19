package algoritmConvertArrayImpl;

import storage.ArrayStorage;
/**
 * Класс для алгоритмов по закручиванию в спираль массивов<br>
 * storage -> Обёртка для int[][]<br>
 * Example:<br>
 * generateArray(3,3) - ><br>
 *  1 2 3<br>
 *  8 9 4<br>
 *  7 6 5<br>
 *
 * generateArray - начать генерацию массива<br>
 * getArray - возвращает сгенерированный массив из {@link ArrayStorage}<br>
 */
public abstract class AlgorithmBase {
    protected ArrayStorage storage;

    public AlgorithmBase(int rows, int columns) {
        this.storage = new ArrayStorage(rows,columns);
    }

    public abstract int[][] generateArray();
    public abstract int[][] getArray();

}
