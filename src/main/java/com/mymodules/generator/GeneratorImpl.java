package com.mymodules.generator;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.ClassicFillAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.SpiralAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.AlgorithmsList;

/**
 * Фабрика + Bridge. Где: <br>
 * Мост выступает - {@link AlgorithmGenerateArray}<br>
 * Фабрика: фабричный метод changeAlgorithmGeneration()<br>
 * <p>
 * Конструктор принимает размерность массива и алгоритм из {@link AlgorithmsList}<br>
 */
public final class GeneratorImpl implements IGenerator {
    private final int _rows;
    private final int _column;
    private AlgorithmGenerateArray _algorithm;
    private boolean _algorithmIsChanged = false;

    public GeneratorImpl(int rows, int columns, AlgorithmsList algorithmsType) {
        _rows=rows;
        _column=columns;
        chooseAnAlgorithm(algorithmsType);
    }

    @Override
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

    @Override
    public int[][] getArray() {
        if (_algorithmIsChanged) {
            _algorithm.generateArray();
            _algorithmIsChanged = false;
        }
        return _algorithm.getArray();
    }

    @Override
    public String report() {
        return this.defaultReport(getArray());
    }
}
