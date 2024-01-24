package com.mymodules.generator;

import com.mymodules.algoritmConvertArrayImpl.enumAlgorithm.AlgorithmsEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {

    @Test
    void classicAlgorithm(){
        IGenerator generator=Generator.createDefault(3,3, AlgorithmsEnum.CLASSIC_FILL);
        int[][] expected={{1,2,3},{4,5,6},{7,8,9}};
        assertArrayEquals(expected, generator.getArray());
    }

    @Test
    void spiralAlgorithm(){
        IGenerator generator=Generator.createDefault(3,3, AlgorithmsEnum.SPIRAL);
        int[][] expected={{1,2,3},{8,9,4},{7,6,5}};
        assertArrayEquals(expected, generator.getArray());
    }

    @Test
    void checkImmutableArray(){
        IGenerator generator=Generator.createDefault(3,3, AlgorithmsEnum.CLASSIC_FILL);
        int[][] newArr= generator.getArray();
        assertFalse(newArr== generator.getArray());
    }

    @Test
    void changeAlgorithmCheckResult(){
        IGenerator generator=Generator.createDefault(3,3, AlgorithmsEnum.CLASSIC_FILL);
        generator.selectAlgorithmFromEnum(AlgorithmsEnum.SPIRAL);
        int[][] expected={{1,2,3},{8,9,4},{7,6,5}};
        assertArrayEquals(expected, generator.getArray());
    }

    @Test
    void AreTheStoragesDifferent(){
        IGenerator generator=Generator.createDefault(3,3, AlgorithmsEnum.SPIRAL);
        generator.getArray();
        IGenerator generator2=Generator.createDefault(3,3, AlgorithmsEnum.SPIRAL);
        generator2.getArray();
        assertFalse(generator==generator2);

    }

}