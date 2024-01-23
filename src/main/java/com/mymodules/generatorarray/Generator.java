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
    private final int _rows;
    private final int _column;
    private AlgorithmGenerateArray _algorithm;
    private boolean _algorithmIsChanged = false;

    public Generator(int rows, int columns, AlgorithmsList algorithmsType) {
        _rows=rows;
        _column=columns;
        chooseAnAlgorithm(algorithmsType);
    }

    public void chooseAnAlgorithm(AlgorithmsList algorithm) {
        if (!_algorithmIsChanged) _algorithmIsChanged=true;

        switch (algorithm) {
            case SPIRAL: {
                _algorithm = new SpiralAlgorithmGenerateArray(_rows, _column);
                break;
            }
            case CLASSIC_FILL: {
                _algorithm = new ClassicFillAlgorithmGenerateArray(_rows, _column);
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
        if (_algorithmIsChanged) {
            _algorithm.generateArray();
            _algorithmIsChanged = false;
        }
        return _algorithm.getArray();
    }
}
