package com.mymodules.generator;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.ClassicFillAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.SpiralAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.AlgorithmsList;
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
    private final int _rows;
    private final int _column;
    private AlgorithmGenerateArray _algorithm;
    private boolean _algorithmIsChanged = false;

    private Generator(int rows, int columns, AlgorithmsList algorithmsType) {
        _rows=rows;
        _column=columns;
        chooseAnAlgorithm(algorithmsType);
    }

    private Generator(int rows, int columns, AlgorithmGenerateArray algorithmGenerate) {
        _rows=rows;
        _column=columns;
        _algorithm=algorithmGenerate;
    }

    public static Generator createDefault(int rows, int columns, AlgorithmsList algorithmsType){
        return new Generator(rows,columns,algorithmsType);
    }
    public static Generator createCustomAlgorithm(int rows, int columns, AlgorithmGenerateArray algorithmGenerate){
        return new Generator(rows,columns,algorithmGenerate);
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
    public String HtmlStatement() {
        return new HtmlStatement().value(getArray());
    }

    @Override
    public String TextStatement() {
        return new TextStatement().value(getArray());
    }
}
