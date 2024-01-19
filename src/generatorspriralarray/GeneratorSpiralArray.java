package generatorspriralarray;

import algoritmConvertArrayImpl.AlgorithmBase;
import algoritmConvertArrayImpl.DefaultSpiralAlgorithmImpl;
import algoritmConvertArrayImpl.SpiralAlgorithms;
import arrayinstrumentalinterfaces.SpiralConverterInterface;

public class GeneratorSpiralArray implements SpiralConverterInterface {

    private final AlgorithmBase converter;

    public GeneratorSpiralArray(int rows, int columns, SpiralAlgorithms spiralAlgorithms) {
        switch (spiralAlgorithms) {
            case DEFAULT: {
                converter = new DefaultSpiralAlgorithmImpl(rows, columns);
                converter.generateArray();
                break;
            }
            default:
                throw new RuntimeException("Список не поддерживает такой тип алгоритма");
        }
    }


    @Override
    public void printArray() {
        this.print(converter.getSpiralArray());
    }

    @Override
    public int[][] getSpiralArray() {
        return converter.getSpiralArray();
    }
}
