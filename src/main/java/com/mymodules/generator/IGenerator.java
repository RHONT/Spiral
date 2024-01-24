package com.mymodules.generator;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmsList;

public interface IGenerator {
     void chooseAnAlgorithm(AlgorithmsList algorithm);
     int[][] getArray();
     String HtmlStatement();
     String TextStatement();
}
