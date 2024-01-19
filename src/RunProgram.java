import algoritmConvertArrayImpl.SpiralAlgorithms;
import generatorspriralarray.GeneratorSpiralArray;

public class RunProgram {
    public static void main(String[] args) {
        GeneratorSpiralArray generatorSpiralArray =new GeneratorSpiralArray(10,5, SpiralAlgorithms.DEFAULT);
        generatorSpiralArray.printArray();
    }
}
