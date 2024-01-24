package com.mymodules.generator;

import com.mymodules.algoritmConvertArrayImpl.enumAlgorithm.AlgorithmsEnum;

public interface IGenerator {
     void selectAlgorithmFromEnum(AlgorithmsEnum algorithm);
     int[][] getArray();
     String HtmlStatement();
     String TextStatement();
}
