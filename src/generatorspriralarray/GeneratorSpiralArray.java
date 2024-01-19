package generatorspriralarray;

import algoritmConvertArrayImpl.AlgorithmBase;
import algoritmConvertArrayImpl.DefaultSpiralAlgorithm;
import algoritmConvertArrayImpl.SpiralAlgorithms;
import arrayinstrumentalinterfaces.SpiralConverterInterface;

/**
 * Конструктор принимает размерность массива и алгоритм из {@link SpiralAlgorithms}<br>
 */
public class GeneratorSpiralArray implements SpiralConverterInterface {

    private final AlgorithmBase converter;
    private final SpiralAlgorithms algorithms;

    public GeneratorSpiralArray(int rows, int columns, SpiralAlgorithms spiralAlgorithms) {
        this.algorithms=spiralAlgorithms;

        switch (algorithms) {
            case DEFAULT: {
                converter = new DefaultSpiralAlgorithm(rows, columns);
                converter.generateArray();
                break;
            }
            default:
                throw new RuntimeException("Алгоритм не включен в switch-case класса " +this.getClass());
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
