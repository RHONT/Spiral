package algoritmConvertArrayImpl;

import arrayInstrumentalInterfaces.SpiralCreateInterface;

import java.util.Optional;

public class DefaultSpiralConverterImpl implements SpiralCreateInterface{
    private final int rows;
    private final int column;
    private final int[][] spiralArray;
    private int sumElement;
    private int globIncr = 1;
    private int markerRows = 0;
    private int markerColumn = 0;
    private int tempMarker = 0;


    public DefaultSpiralConverterImpl(int rows, int columns) {
        this.spiralArray=new int[rows][columns];
        this.rows = spiralArray.length;
        this.column = spiralArray[0].length;
        this.sumElement = rows*column;

    }

    @Override
    public Optional<int[][]> generateArray() {

        while (true) {
            if (!writeDigitToRightInSingleRow(spiralArray)) break;
            if (!writeDigitToLeftInSingleRow(spiralArray)) break;
            if (!writeDigitToDownInSingleColumn(spiralArray)) break;
            if (!writeDigitToUpInSingleColumn(spiralArray)) break;
        }

        return Optional.of(spiralArray);
    }

    private boolean writeDigitToRightInSingleRow(int[][] arrS) {
        for (int i = markerColumn; i < column; i++) {
            if (arrS[markerRows][i] == 0) {
                arrS[markerRows][i] = globIncr++;
                tempMarker = i;
                sumElement--;
            } else
                break;
        }
        markerColumn = tempMarker;
        markerRows++;
        return sumElement >0;
    }

    private boolean writeDigitToUpInSingleColumn(int[][] arrS) {
        for (int j = markerRows; j >= 0; j--) {
            if (arrS[j][markerColumn] == 0) {
                arrS[j][markerColumn] = globIncr++;
                tempMarker = j;
                sumElement--;
            } else break;
        }
        markerRows = tempMarker;
        markerColumn++;
        return sumElement >0;
    }

    private boolean writeDigitToDownInSingleColumn(int[][] arrS) {
        for (int i = markerColumn; i >= 0; i--) {
            if (arrS[markerRows][i] == 0) {
                arrS[markerRows][i] = globIncr++;
                tempMarker = i;
                sumElement--;
            } else
                break;
        }
        markerColumn = tempMarker;
        markerRows--;
        return sumElement >0;
    }

    private boolean writeDigitToLeftInSingleRow(int[][] arrS) {
        for (int j = markerRows; j < rows; j++) {
            if (arrS[j][markerColumn] == 0) {
                arrS[j][markerColumn] = globIncr++;
                tempMarker = j;
                sumElement--;
            } else break;
        }
        markerRows = tempMarker;
        markerColumn--;
        return sumElement >0;
    }

    public Optional<int[][]> getSpiralArray() {
        return Optional.of(spiralArray);
    }

}