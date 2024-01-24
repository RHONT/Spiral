package com.mymodules.generator.statement;


/**
 * Вывод массива в ASCII простым текстом
 */
public class TextStatement extends Statement {
    @Override
     void setDelimiter() {
        _delimiterLine ="\n";
    }
}
