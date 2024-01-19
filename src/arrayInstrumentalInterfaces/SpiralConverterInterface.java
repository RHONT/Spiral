package arrayInstrumentalInterfaces;

import java.util.Arrays;
import java.util.Optional;


public interface SpiralConverterInterface {
    int[][] getSpiralArray();
    void printArray();
    default void print(Optional<int[][]> inputArray){
        inputArray.ifPresent(spiralArray->{
            for (var element: spiralArray) {
                System.out.println(Arrays.toString(element));
            }
        });
    }
}
