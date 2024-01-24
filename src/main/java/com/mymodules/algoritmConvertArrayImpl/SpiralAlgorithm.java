package com.mymodules.algoritmConvertArrayImpl;

/**
 * Example:<br>
 * 1 2 3<br>
 * 8 9 4<br>
 * 7 6 5<br>
 * Алгоритм закручивате спираль при помощи четырех методов<br>
 * вправо / вниз / влево / вправо<br>
 * totalIncrement - возрастание значений после каждой записи на 1<br>
 * cursorRows - указатель текущего положения для строк<br>
 * cursorColumn - аналогично<br>
 * cursorTemp - принимает значение индекса по завершению каждой итерации. Имеет влияние на cursorRows/cursorColumn<br>
 */
public final class SpiralAlgorithm extends AlgorithmGenerateArray {

    private int _totalIncrement = 1;
    private int _cursorRows = 0;
    private int _cursorColumn = 0;
    private int _cursorTemp = 0;

    @Override
    public int[][] generateArray() {
        while (_storage.getSumElement() > 0) {
            if (!writeDigitToRightInSingleRow(_storage.getArray())) break;
            if (!writeDigitToDownInSingleColumn(_storage.getArray())) break;
            if (!writeDigitToLeftInSingleRow(_storage.getArray())) break;
            if (!writeDigitToUpInSingleColumn(_storage.getArray())) break;
        }
        return _storage.getArray();
    }

    private boolean writeDigitToRightInSingleRow(int[][] arrS) {
        for (int i = _cursorColumn; i < _storage.getColumn(); i++) {
            if (arrS[_cursorRows][i] == 0) {
                arrS[_cursorRows][i] = _totalIncrement++;
                _cursorTemp = i;
                _storage.reduceByOne();
            } else
                break;
        }
        _cursorColumn = _cursorTemp;
        _cursorRows++;
        return _storage.getSumElement() > 0;
    }

    private boolean writeDigitToUpInSingleColumn(int[][] arrS) {
        for (int j = _cursorRows; j >= 0; j--) {
            if (arrS[j][_cursorColumn] == 0) {
                arrS[j][_cursorColumn] = _totalIncrement++;
                _cursorTemp = j;
                _storage.reduceByOne();
            } else break;
        }
        _cursorRows = _cursorTemp;
        _cursorColumn++;
        return _storage.getSumElement() > 0;
    }

    private boolean writeDigitToLeftInSingleRow(int[][] arrS) {
        for (int i = _cursorColumn; i >= 0; i--) {
            if (arrS[_cursorRows][i] == 0) {
                arrS[_cursorRows][i] = _totalIncrement++;
                _cursorTemp = i;
                _storage.reduceByOne();
            } else
                break;
        }
        _cursorColumn = _cursorTemp;
        _cursorRows--;
        return _storage.getSumElement() > 0;
    }

    private boolean writeDigitToDownInSingleColumn(int[][] arrS) {
        for (int j = _cursorRows; j < _storage.getRows(); j++) {
            if (arrS[j][_cursorColumn] == 0) {
                arrS[j][_cursorColumn] = _totalIncrement++;
                _cursorTemp = j;
                _storage.reduceByOne();
            } else break;
        }
        _cursorRows = _cursorTemp;
        _cursorColumn--;
        return _storage.getSumElement() > 0;
    }



}