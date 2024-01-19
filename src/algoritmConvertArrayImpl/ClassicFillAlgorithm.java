package algoritmConvertArrayImpl;

/**
 * Example:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 */
public class ClassicFillAlgorithm extends BaseForAlgorithm {
    public ClassicFillAlgorithm(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    public int[][] generateArray() {
        int incr=1;
        int[][] array= storage.getArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j]=incr++;
            }
        }
        return array;
    }
}
