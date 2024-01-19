package arrayinstrumentalinterfaces;

import java.util.Arrays;

/**
 * Интерфейс для генератора массива<br>
 * Отдает готовый результат<br>
 * Умеет печатать в консоль результат 2d массива<br>
 */
public interface SpiralConverterInterface {
    int[][] getSpiralArray();

    void printArray();

    default void print(int[][] inputArray) {
        for (var element : inputArray) {
            System.out.println(Arrays.toString(element));
        }
    }
}
