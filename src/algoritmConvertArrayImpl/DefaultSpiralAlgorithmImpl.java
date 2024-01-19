package algoritmConvertArrayImpl;

public final class DefaultSpiralAlgorithmImpl extends AlgorithmBase{

    private int globIncr = 1;
    private int markerRows = 0;
    private int markerColumn = 0;
    private int tempMarker = 0;

    public DefaultSpiralAlgorithmImpl(int rows, int columns) {
        super(rows,columns);
    }

    @Override
    public int[][] generateArray() {

        while (true) {
            if (!writeDigitToRightInSingleRow(storage.getSpiralArray())) break;
            if (!writeDigitToLeftInSingleRow(storage.getSpiralArray())) break;
            if (!writeDigitToDownInSingleColumn(storage.getSpiralArray())) break;
            if (!writeDigitToUpInSingleColumn(storage.getSpiralArray())) break;
        }

        return storage.getSpiralArray();
    }

    private boolean writeDigitToRightInSingleRow(int[][] arrS) {
        for (int i = markerColumn; i < storage.getColumn(); i++) {
            if (arrS[markerRows][i] == 0) {
                arrS[markerRows][i] = globIncr++;
                tempMarker = i;
                storage.reduceByOne();
            } else
                break;
        }
        markerColumn = tempMarker;
        markerRows++;
        return storage.getSumElement() >0;
    }

    private boolean writeDigitToUpInSingleColumn(int[][] arrS) {
        for (int j = markerRows; j >= 0; j--) {
            if (arrS[j][markerColumn] == 0) {
                arrS[j][markerColumn] = globIncr++;
                tempMarker = j;
                storage.reduceByOne();
            } else break;
        }
        markerRows = tempMarker;
        markerColumn++;
        return storage.getSumElement() >0;
    }

    private boolean writeDigitToDownInSingleColumn(int[][] arrS) {
        for (int i = markerColumn; i >= 0; i--) {
            if (arrS[markerRows][i] == 0) {
                arrS[markerRows][i] = globIncr++;
                tempMarker = i;
                storage.reduceByOne();
            } else
                break;
        }
        markerColumn = tempMarker;
        markerRows--;
        return storage.getSumElement()  >0;
    }

    private boolean writeDigitToLeftInSingleRow(int[][] arrS) {
        for (int j = markerRows; j < storage.getRows(); j++) {
            if (arrS[j][markerColumn] == 0) {
                arrS[j][markerColumn] = globIncr++;
                tempMarker = j;
                storage.reduceByOne();
            } else break;
        }
        markerRows = tempMarker;
        markerColumn--;
        return storage.getSumElement()  >0;
    }

    @Override
    public int[][] getSpiralArray() {
        return storage.getSpiralArray();
    }
}