package com.mymodules.algoritmConvertArrayImpl.enumAlgorithm;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmGenerateArray;
import com.mymodules.algoritmConvertArrayImpl.ClassicAlgorithm;
import com.mymodules.algoritmConvertArrayImpl.SpiralAlgorithm;

import java.util.function.Supplier;

/**
 * Список алгоритмов генерации массивов
 */
public enum AlgorithmsEnum {
    SPIRAL(SpiralAlgorithm::new),
    CLASSIC_FILL(ClassicAlgorithm::new);

    private final Supplier<AlgorithmGenerateArray> _algorithmSupplier;

    AlgorithmsEnum(Supplier<AlgorithmGenerateArray> _algorithmSupplier) {
        this._algorithmSupplier = _algorithmSupplier;
    }

    public  AlgorithmGenerateArray getInstance(){
        return _algorithmSupplier.get();
    }
}
