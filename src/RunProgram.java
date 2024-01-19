import algoritmConvertArrayImpl.AlgorithmsList;
import generatorarray.Generator;

public class RunProgram {
    public static void main(String[] args) {
        Generator generator =new Generator(5,5, AlgorithmsList.SPIRAL);
        generator.printArray();
        System.out.println("=".repeat(20));
        generator.changeAlgorithmGeneration(AlgorithmsList.CLASSIC_FILL);
        generator.printArray();
    }
}
