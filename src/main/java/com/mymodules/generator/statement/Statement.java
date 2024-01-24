package com.mymodules.generator.statement;

import java.util.Arrays;

/**
 * Адаптация вывода массива для разных целей
 */
public abstract class Statement {
    protected String _head= "Массив сгенерирован:";
    protected String _delimiter;
    protected StringBuilder sb=new StringBuilder();

    public Statement() {
        setDelimiter();
    }

    public String value(int[][] inputArray) {
        sb.append(_head);
        sb.append(_delimiter);
        for (var element : inputArray) {
            sb.append(Arrays.toString(element)).append(_delimiter);
        }
        return sb.toString();
    }

    abstract void setDelimiter();
}
