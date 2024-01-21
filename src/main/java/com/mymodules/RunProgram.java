package com.mymodules;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmsList;
import com.mymodules.generatorarray.Generator;

public class RunProgram {
    public static void main(String[] args) {
        Generator generator =new Generator(5,5, AlgorithmsList.SPIRAL);
        generator.printArray();
        System.out.println("=".repeat(20));
        generator.chooseAnAlgorithm(AlgorithmsList.CLASSIC_FILL);
        generator.printArray();
    }
}
