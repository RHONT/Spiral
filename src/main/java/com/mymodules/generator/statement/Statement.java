package com.mymodules.generator.statement;

import java.util.Arrays;

/**
 * Адаптация вывода массива для разных целей
 */
public abstract class Statement {
    protected String _head= "Массив сгенерирован:";
    protected String _delimiterLine;
    protected StringBuilder _sb =new StringBuilder();

    public Statement() {
        setDelimiter();
    }

    public String value(int[][] inputArray) {
        _sb.append(_head);
        _sb.append(_delimiterLine);
        for (var element : inputArray) {
            _sb.append(Arrays.toString(element)).append(_delimiterLine);
        }
        return _sb.toString();
    }

    abstract void setDelimiter();
}
