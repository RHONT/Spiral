package com.mymodules.generator;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.enumAlgorithm.AlgorithmsEnum;
import com.mymodules.generator.statement.HtmlStatement;
import com.mymodules.generator.statement.TextStatement;

/**
 * Конструкторы заменил фабричными методами:<br>
 * Один берет алгоритмы из enum, а во второй можно положить кастомный алгоритм.<br>
 * Паттерн команда где:<br>
 * Инициатор: выступает - {@link Generator}<br>
 * Получатель: - {@link AlgorithmGenerateArray}<br>
 * <p>
 * Конструкторы принимают размерность массива и алгоритм из {@link AlgorithmsEnum}<br>
 *
 * _algorithm - алгоритм генерации массива<br>
 * _algorithmIsChanged - если true, значит требуется действия по генерации, если нет, то возвращаем существующую<br>
 * копию сгенерированного массива ранее. Нужно для того, чтобы при вызове метода getArray(), делать каждый раз генерацию.<br>
 */
public final class Generator implements IGenerator {

    private AlgorithmGenerateArray _algorithm;
    private boolean _doCalculate =true;

    private Generator(int rows, int columns, AlgorithmsEnum algorithmsType) {
        selectAlgorithmFromEnum(algorithmsType);
        _algorithm.createStorage(rows, columns);
    }

    private Generator(int rows, int columns, AlgorithmGenerateArray algorithmGenerate) {
        _algorithm = algorithmGenerate;
        _algorithm.createStorage(rows, columns);
    }

    public static Generator createDefault(int rows, int columns, AlgorithmsEnum algorithmsType) {
        return new Generator(rows, columns, algorithmsType);
    }

    public static Generator createCustomAlgorithm(int rows, int columns, AlgorithmGenerateArray algorithmGenerate) {
        return new Generator(rows, columns, algorithmGenerate);
    }

    /**
     * Выбираем алгоритм для генерации.
     * Создает класс из enum AlgorithmsList
     * Если алгоритм меняется в уже созданном объекте,
     * мы обновляем хранилище в объекте AlgorithmGenerateArray,
     * так как значения будут обновлены
     */
    @Override
    public void selectAlgorithmFromEnum(AlgorithmsEnum algorithm) {
        if (_algorithm!=null) {
            int tempRows = _algorithm.getArray().length;
            int tempColumns = _algorithm.getArray()[0].length;
            _algorithm=algorithm.getInstance();
            _algorithm.createStorage(tempRows, tempColumns);
            _doCalculate =true;

        } else _algorithm = algorithm.getInstance();
    }

    @Override
    public int[][] getArray() {
        if (_doCalculate) {
            _algorithm.generateArray();
            _doCalculate = false;
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
