package arrayinstrumentalinterfaces;

import algoritmConvertArrayImpl.AlgorithmsForArrays;

import java.util.Arrays;

/**
 * Интерфейс для генератора массива<br>
 * getSpiralArray - Отдает готовый результат<br>
 * printArray - Умеет печатать в консоль результат 2d массива<br>
 * changeAlgorithm - изменяет алгоритм генерации
 */
public interface GeneratorsArrays {
    int[][] getSpiralArray();
    void changeAlgorithmGeneration(AlgorithmsForArrays algorithm);

    void printArray();

    default void print(int[][] inputArray) {
        for (var element : inputArray) {
            System.out.println(Arrays.toString(element));
        }
    }
}
