package com.mymodules.generatorarray;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.ClassicFillAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.SpiralAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.AlgorithmsList;
import com.mymodules.arrayinstrumentalinterfaces.AdditionalFunctionalityForGeneratorArrays;

/**
 * Фабрика + Bridge. Где: <br>
 * Мост выступает - {@link AlgorithmGenerateArray}<br>
 * Фабрика: фабричный метод changeAlgorithmGeneration()<br>
 * <p>
 * Конструктор принимает размерность массива и алгоритм из {@link AlgorithmsList}<br>
 */
public final class Generator implements AdditionalFunctionalityForGeneratorArrays {
    private final int rows;
    private final int columns;
    private AlgorithmGenerateArray algorithm;

    public Generator(int rows, int columns, AlgorithmsList algorithmsType) {
        this.rows = rows;
        this.columns = columns;
        chooseAnAlgorithm(algorithmsType);
    }

    public void chooseAnAlgorithm(AlgorithmsList algorithm) {
        switch (algorithm) {
            case SPIRAL: {
                this.algorithm = new SpiralAlgorithmGenerateArray(rows, columns);
                break;
            }
            case CLASSIC_FILL: {
                this.algorithm = new ClassicFillAlgorithmGenerateArray(rows, columns);
                break;
            }
            default:
                throw new RuntimeException("Алгоритм не включен в switch-case класса " + this.getClass());
        }

    }

    public void printArray() {
        this.printDefault(getArray());
    }

    public int[][] getArray() {
        this.algorithm.generateArray();
        return algorithm.getArray();
    }

}
