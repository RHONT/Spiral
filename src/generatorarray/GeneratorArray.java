package generatorarray;

import algoritmConvertArrayImpl.AlgorithmBase;
import algoritmConvertArrayImpl.DefaultSpiralAlgorithm;
import algoritmConvertArrayImpl.AlgorithmsForArrays;
import arrayinstrumentalinterfaces.GeneratorsArrays;

/**
 * Паттерн Bridge. Где в качестве моста выступает - {@link AlgorithmBase}
 * Конструктор принимает размерность массива и алгоритм из {@link AlgorithmsForArrays}<br>
 *
 */
public class GeneratorArray implements GeneratorsArrays {
    private final int rows;
    private final int columns;
    private AlgorithmBase generateArray;

    public GeneratorArray(int rows, int columns, AlgorithmsForArrays algorithms) {
        this.rows = rows;
        this.columns = columns;
        changeAlgorithmGeneration(algorithms);
    }

    @Override
    public void changeAlgorithmGeneration(AlgorithmsForArrays algorithm) {
        switch (algorithm) {
            case DEFAULT_SPIRAL: {
                generateArray = new DefaultSpiralAlgorithm(rows, columns);
                generateArray.generateArray();
                break;
            }
            default:
                throw new RuntimeException("Алгоритм не включен в switch-case класса " +this.getClass());
        }
    }

    @Override
    public void printArray() {
        this.print(generateArray.getArray());
    }

    @Override
    public int[][] getSpiralArray() {
        return generateArray.getArray();
    }

}
