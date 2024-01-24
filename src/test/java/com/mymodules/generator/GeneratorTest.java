package com.mymodules.generator;

import com.mymodules.algoritmConvertArrayImpl.AlgorithmsList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    void classicAlgorithm(){
        IGenerator generator=new Generator(3,3, AlgorithmsList.CLASSIC_FILL);
        int[][] expected={{1,2,3},{4,5,6},{7,8,9}};
        assertArrayEquals(expected, generator.getArray());
    }

    @Test
    void spiralAlgorithm(){
        IGenerator generator=new Generator(3,3, AlgorithmsList.SPIRAL);
        int[][] expected={{1,2,3},{8,9,4},{7,6,5}};
        assertArrayEquals(expected, generator.getArray());
    }

    @Test
    void checkImmutableArray(){
        IGenerator generator=new Generator(3,3, AlgorithmsList.CLASSIC_FILL);
        int[][] newArr= generator.getArray();
        assertFalse(newArr== generator.getArray());
    }

    @Test
    void changeAlgorithmCheckResult(){
        IGenerator generator=new Generator(3,3, AlgorithmsList.CLASSIC_FILL);
        generator.chooseAnAlgorithm(AlgorithmsList.SPIRAL);
        int[][] expected={{1,2,3},{8,9,4},{7,6,5}};
        assertArrayEquals(expected, generator.getArray());
    }

}