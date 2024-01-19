import algoritmConvertArrayImpl.AlgorithmsForArrays;
import generatorarray.GeneratorArray;

public class RunProgram {
    public static void main(String[] args) {
        GeneratorArray generatorArray =new GeneratorArray(10,5, AlgorithmsForArrays.DEFAULT_SPIRAL);
        generatorArray.printArray();
    }
}
