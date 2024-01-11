import java.util.Arrays;
import java.util.Random;

public class Main {
    static int sum;
    static int rows;
    static int column;
    static int incrRows;
    static int incrColumn;
    static int globIncr = 1;

    static int markerRows = 0;
    static int markerColumn = 0;

    public static void main(String[] args) {
        int[] array = new Random().ints(5, 1, 10).toArray();
//     int[] array={2, 5, 1, 5, 6};
//     int[] array={6, 8, 3, 9, 5};
//     int[] array={2, 2, 6, 8, 7};

//     int min=Integer.MAX_VALUE;
//     int min_2=Integer.MAX_VALUE;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i]<min) {
//                min_2=min;
//                min=array[i];
//            } else if (array[i]<min_2 && array[i]>min) {
//                min_2=array[i];
//            }
//        }
//        System.out.println(Arrays.toString(array));
//        System.out.println(min);
//        System.out.println(min_2);

        int[][] arrS = new int[3][3];
        System.out.println(arrS[0][1]);
        rows = arrS.length;
        column = arrS[0].length;
        sum = arrS[0].length * arrS.length;
        incrRows = rows;
        incrColumn = column;

        while (sum > 0) {
            if (forward(arrS)) {
                down(arrS);
                back(arrS);
                up(arrS);
            }
        }

    }

    private static void up(int[][] arrS) {
    }

    private static void back(int[][] arrS) {

    }

    private static void down(int[][] arrS) {

        markerColumn=column-incrColumn;
        for (int j = markerColumn; j < rows; j++) {
            if (arrS[j][markerRows] == 0) {
                arrS[j][markerRows] = globIncr++;
                markerRows = j;
            } else break;

        }
        incrColumn--;
    }

    private static boolean forward(int[][] arrS) {
        markerRows = rows - incrRows;
        for (int i = markerRows; i < column; i++) {
            if (arrS[markerRows][i] == 0) {
                arrS[markerRows][i] = globIncr++;
                markerColumn = i;
            } else break;

        }
        incrRows--;

        return true;
    }
}