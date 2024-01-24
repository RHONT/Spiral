package com.mymodules.algoritmConvertArrayImpl.enumAlgorithm;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.ClassicFillAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.SpiralAlgorithmGenerateArray;

/**
 * Список алгоритмов генерации массивов
 */
public enum AlgorithmsList {
    SPIRAL(new SpiralAlgorithmGenerateArray()),
    CLASSIC_FILL(new ClassicFillAlgorithmGenerateArray());

    private AlgorithmGenerateArray algorithmGenerateArray;

    AlgorithmsList(AlgorithmGenerateArray someAlgorithmGenerateArray) {
        algorithmGenerateArray=someAlgorithmGenerateArray;
    }

    public AlgorithmGenerateArray getAlgorithmGenerateArray() {
        return algorithmGenerateArray;
    }
}
