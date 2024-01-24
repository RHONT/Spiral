package com.mymodules.generator.statement;

import java.util.Arrays;

/**
 * Вывод массива в ASCII простым текстом
 */
public class TextStatement extends Statement {
    @Override
    public String value(int[][] inputArray) {
        sb.append("\n");
        for (var element : inputArray) {
            sb.append(Arrays.toString(element)).append("\n");
        }
        return sb.toString();
    }
}
