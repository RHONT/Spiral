package com.mymodules.generator.statement;

/**
 * Адаптация вывода массива для разных целей
 */
public abstract class Statement {
    private String head= "Массив сгенерирован:";
    protected StringBuilder sb=new StringBuilder(head);
    public abstract String value(int[][] inputArray);
}
