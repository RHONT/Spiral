package generatorspriralarray;

import algoritmConvertArrayImpl.AlgorithmBase;
import algoritmConvertArrayImpl.DefaultSpiralAlgorithmImpl;
import algoritmConvertArrayImpl.SpiralAlgorithms;
import arrayinstrumentalinterfaces.SpiralConverterInterface;

/**
 * Конструктор принимает размерность массива и алгоритм из {@link SpiralAlgorithms}<br>
 */
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
