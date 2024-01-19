package algoritmConvertArrayImpl;

/**
 * Алгоритм закручивате спираль при помощи четырех методов<br>
 * вправо / вниз / влево / вправо<br>
 * totalIncrement - возрастание значений после каждой записи на 1<br>
 * cursorRows - указатель текущего положения для строк<br>
 * cursorColumn - аналогично<br>
 * cursorTemp - принимает значение индекса по завершению каждой итерации. Имеет влияние на cursorRows/cursorColumn<br>
 */
public final class DefaultSpiralAlgorithm extends AlgorithmBase{

    private int totalIncrement = 1;
    private int cursorRows = 0;
    private int cursorColumn = 0;
    private int cursorTemp = 0;

    public DefaultSpiralAlgorithm(int rows, int columns) {
        super(rows,columns);
    }

    @Override
    public int[][] generateArray() {

        while (storage.getSumElement()>0) {
            if (!writeDigitToRightInSingleRow(storage.getSpiralArray())) break;
            if (!writeDigitToDownInSingleColumn(storage.getSpiralArray())) break;
            if (!writeDigitToLeftInSingleRow(storage.getSpiralArray())) break;
            if (!writeDigitToUpInSingleColumn(storage.getSpiralArray())) break;
        }

        return storage.getSpiralArray();
    }

    private boolean writeDigitToRightInSingleRow(int[][] arrS) {
        for (int i = cursorColumn; i < storage.getColumn(); i++) {
            if (arrS[cursorRows][i] == 0) {
                arrS[cursorRows][i] = totalIncrement++;
                cursorTemp = i;
                storage.reduceByOne();
            } else
                break;
        }
        cursorColumn = cursorTemp;
        cursorRows++;
        return storage.getSumElement() >0;
    }

    private boolean writeDigitToUpInSingleColumn(int[][] arrS) {
        for (int j = cursorRows; j >= 0; j--) {
            if (arrS[j][cursorColumn] == 0) {
                arrS[j][cursorColumn] = totalIncrement++;
                cursorTemp = j;
                storage.reduceByOne();
            } else break;
        }
        cursorRows = cursorTemp;
        cursorColumn++;
        return storage.getSumElement() >0;
    }

    private boolean writeDigitToLeftInSingleRow(int[][] arrS) {
        for (int i = cursorColumn; i >= 0; i--) {
            if (arrS[cursorRows][i] == 0) {
                arrS[cursorRows][i] = totalIncrement++;
                cursorTemp = i;
                storage.reduceByOne();
            } else
                break;
        }
        cursorColumn = cursorTemp;
        cursorRows--;
        return storage.getSumElement()  >0;
    }

    private boolean writeDigitToDownInSingleColumn(int[][] arrS) {
        for (int j = cursorRows; j < storage.getRows(); j++) {
            if (arrS[j][cursorColumn] == 0) {
                arrS[j][cursorColumn] = totalIncrement++;
                cursorTemp = j;
                storage.reduceByOne();
            } else break;
        }
        cursorRows = cursorTemp;
        cursorColumn--;
        return storage.getSumElement()  >0;
    }

    @Override
    public int[][] getArray() {
        return storage.getSpiralArray();
    }
}