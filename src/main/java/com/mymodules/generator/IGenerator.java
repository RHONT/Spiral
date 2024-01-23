package com.mymodules.generator;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmsList;

import java.util.Arrays;

public interface IGenerator {
     void chooseAnAlgorithm(AlgorithmsList algorithm);
     int[][] getArray();
     String report();
     default String defaultReport(int[][] inputArray) {
          StringBuilder sb=new StringBuilder();
          for (var element : inputArray) {
               sb.append(Arrays.toString(element)).append("\n");
          }
          return sb.toString();
     }
}
