package com.mymodules.generator;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.ClassicFillAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.SpiralAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.enumAlgorithm.AlgorithmsList;
import com.mymodules.generator.statement.HtmlStatement;
import com.mymodules.generator.statement.TextStatement;

/**
 * Фабрика + Bridge. Где: <br>
 * Мост выступает - {@link AlgorithmGenerateArray}<br>
 * Фабрика: фабричный метод changeAlgorithmGeneration()<br>
 * <p>
 * Конструктор принимает размерность массива и алгоритм из {@link AlgorithmsList}<br>
 */
public final class Generator implements IGenerator {

    private AlgorithmGenerateArray _algorithm;
    private boolean _algorithmIsChanged=true;

    private Generator(int rows, int columns, AlgorithmsList algorithmsType) {
        chooseAnAlgorithm(algorithmsType);
        _algorithm.createStorage(rows, columns);
    }

    private Generator(int rows, int columns, AlgorithmGenerateArray algorithmGenerate) {
        _algorithm = algorithmGenerate;
        _algorithm.createStorage(rows, columns);
    }

    public static Generator createDefault(int rows, int columns, AlgorithmsList algorithmsType) {
        return new Generator(rows, columns, algorithmsType);
    }

    public static Generator createCustomAlgorithm(int rows, int columns, AlgorithmGenerateArray algorithmGenerate) {
        return new Generator(rows, columns, algorithmGenerate);
    }

    @Override
    public void chooseAnAlgorithm(AlgorithmsList algorithm) {
        if (_algorithm!=null) {
            int tempRows = _algorithm.getArray().length;
            int tempColumns = _algorithm.getArray()[0].length;
            _algorithm=algorithm.getAlgorithmGenerateArray();
            _algorithm.createStorage(tempRows, tempColumns);
            _algorithmIsChanged=true;

        } else _algorithm = algorithm.getAlgorithmGenerateArray();
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
    public String HtmlStatement() {
        return new HtmlStatement().value(getArray());
    }

    @Override
    public String TextStatement() {
        return new TextStatement().value(getArray());
    }
}
