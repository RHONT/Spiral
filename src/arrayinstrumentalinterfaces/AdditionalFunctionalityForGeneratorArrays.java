package arrayinstrumentalinterfaces;

import java.util.Arrays;

/**
 * Дополнительный функционал для генератора массива<br>
 * getArray - Отдает готовый результат<br>
 * printArray - Умеет печатать в консоль результат 2d массива<br>
 */
public interface AdditionalFunctionalityForGeneratorArrays {

    void printArray();

    default void printDefault(int[][] inputArray) {
        for (var element : inputArray) {
            System.out.println(Arrays.toString(element));
        }
    }
}
