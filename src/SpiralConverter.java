import java.util.Arrays;

public class SpiralConverter {
    private final int rows;
    private final int column;
    private final int[][] spiralArray;
    private int sum;
    private int globIncr = 1;
    private int markerRows = 0;
    private int markerColumn = 0;
    private int tempMarker = 0;


    public SpiralConverter(int rows, int column) {
        this.rows = rows;
        this.column = column;
        sum = rows*column;
        this.spiralArray = new int[rows][column];
        runSpiralWrite();
    }

    private void runSpiralWrite(){
        while (true) {
            if (!forward(spiralArray)) break;
            if (!down(spiralArray)) break;
            if (!back(spiralArray)) break;
            if (!up(spiralArray)) break;
        }
    }

    private boolean forward(int[][] arrS) {
        for (int i = markerColumn; i < column; i++) {
            if (arrS[markerRows][i] == 0) {
                arrS[markerRows][i] = globIncr++;
                tempMarker = i;
                sum--;
            } else
                break;
        }
        markerColumn = tempMarker;
        markerRows++;
        return sum>0;
    }

    private boolean up(int[][] arrS) {
        for (int j = markerRows; j >= 0; j--) {
            if (arrS[j][markerColumn] == 0) {
                arrS[j][markerColumn] = globIncr++;
                tempMarker = j;
                sum--;
            } else break;
        }
        markerRows = tempMarker;
        markerColumn++;
        return sum>0;
    }

    private boolean back(int[][] arrS) {
        for (int i = markerColumn; i >= 0; i--) {
            if (arrS[markerRows][i] == 0) {
                arrS[markerRows][i] = globIncr++;
                tempMarker = i;
                sum--;
            } else
                break;
        }
        markerColumn = tempMarker;
        markerRows--;
        return sum>0;
    }

    private boolean down(int[][] arrS) {
        for (int j = markerRows; j < rows; j++) {
            if (arrS[j][markerColumn] == 0) {
                arrS[j][markerColumn] = globIncr++;
                tempMarker = j;
                sum--;
            } else break;
        }
        markerRows = tempMarker;
        markerColumn--;
        return sum>0;
    }

    public int[][] getSpiralArray() {
        return spiralArray;
    }

    public void printSpriralArray(){
        for (var element: spiralArray) {
            System.out.println(Arrays.toString(element));
        }
    }
}