package com.mymodules.algoritmConvertArrayImpl.enumAlgorithm;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.ClassicFillAlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.SpiralAlgorithmGenerateArray;

import java.util.function.Supplier;

/**
 * Список алгоритмов генерации массивов
 */
public enum AlgorithmsList {
    SPIRAL(SpiralAlgorithmGenerateArray::new),
    CLASSIC_FILL(ClassicFillAlgorithmGenerateArray::new);

    private final Supplier<AlgorithmGenerateArray> _algorithmSupplier;

    AlgorithmsList(Supplier<AlgorithmGenerateArray> _algorithmSupplier) {
        this._algorithmSupplier = _algorithmSupplier;
    }

    public  AlgorithmGenerateArray getInstance(){
        return _algorithmSupplier.get();
    }
}
