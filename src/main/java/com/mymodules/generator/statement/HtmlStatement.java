package com.mymodules.generator.statement;

import java.util.Arrays;

/**
 * Вывод массива для HTML страниц
 */
public class HtmlStatement extends Statement {
    @Override
    public String value(int[][] inputArray) {
        sb.append("<BR>");
        for (var element : inputArray) {
            sb.append(Arrays.toString(element)).append("<BR>");
        }
        return sb.toString();
    }
}
