package com.mymodules.generator.statement;


/**
 * Вывод массива для HTML страниц
 */
public class HtmlStatement extends Statement {
    @Override
    void setDelimiter() {
        _delimiter="<BR>";
    }
}
