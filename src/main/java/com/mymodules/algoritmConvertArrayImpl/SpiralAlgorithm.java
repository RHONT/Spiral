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
        while (_storage.get_total()+1 > _totalIncrement) {
            if (!writeDigitToRightInSingleRow(_storage.getArrayForOperation())) break;
            if (!writeDigitToDownInSingleColumn(_storage.getArrayForOperation())) break;
            if (!writeDigitToLeftInSingleRow(_storage.getArrayForOperation())) break;
            if (!writeDigitToUpInSingleColumn(_storage.getArrayForOperation())) break;
        }
        return _storage.getArray();
    }

    private boolean writeDigitToRightInSingleRow(int[][] arrS) {
        for (int i = _cursorColumn; i < _storage.getColumn(); i++) {
            if (!writeRow(arrS, i)) break;
        }
        _cursorColumn = _cursorTemp;
        _cursorRows++;
        return _storage.getSumElement() > 0;
    }

    private boolean writeDigitToLeftInSingleRow(int[][] arrS) {
        for (int i = _cursorColumn; i >= 0; i--) {
            if (!writeRow(arrS, i)) break;
        }
        _cursorColumn = _cursorTemp;
        _cursorRows--;
        return _storage.getSumElement() > 0;
    }



    private boolean writeDigitToUpInSingleColumn(int[][] arrS) {
        for (int j = _cursorRows; j >= 0; j--) {
            if (!writeColumn(arrS, j)) break;
        }
        _cursorRows = _cursorTemp;
        _cursorColumn++;
        return _storage.getSumElement() > 0;
    }


    private boolean writeDigitToDownInSingleColumn(int[][] arrS) {
        for (int j = _cursorRows; j < _storage.getRows(); j++) {
            if (!writeColumn(arrS, j)) break;
        }
        _cursorRows = _cursorTemp;
        _cursorColumn--;
        return _storage.getSumElement() > 0;
    }


    private boolean writeRow(int[][] inputArr, int j) {
        if (inputArr[_cursorRows][j] == 0) {
            inputArr[_cursorRows][j] = _totalIncrement++;
            _cursorTemp = j;
            _storage.reduceByOne();
            return true;
        } else return false;
    }

    private boolean writeColumn(int[][] inputArr, int i) {
        if (inputArr[i][_cursorColumn] == 0) {
            inputArr[i][_cursorColumn] = _totalIncrement++;
            _cursorTemp = i;
            _storage.reduceByOne();
            return true;
        } else return false;
    }

}