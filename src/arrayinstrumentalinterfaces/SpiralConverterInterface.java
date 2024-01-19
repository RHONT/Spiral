package arrayinstrumentalinterfaces;

import java.util.Arrays;

public interface SpiralConverterInterface {
    int[][] getSpiralArray();

    void printArray();

    default void print(int[][] inputArray) {
        for (var element : inputArray) {
            System.out.println(Arrays.toString(element));
        }
    }
}
