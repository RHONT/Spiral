package generatorarray;

import algoritmConvertArrayImpl.BaseForAlgorithm;
import algoritmConvertArrayImpl.ClassicFillAlgorithm;
import algoritmConvertArrayImpl.SpiralAlgorithm;
import algoritmConvertArrayImpl.AlgorithmsList;
import arrayinstrumentalinterfaces.AdditionalFunctionalityForGeneratorArrays;

/**
 * Фабрика + Bridge. Где: <br>
 * Мост выступает - {@link BaseForAlgorithm}<br>
 * Фабрика: фабричный метод changeAlgorithmGeneration()<br>
 *
 * Конструктор принимает размерность массива и алгоритм из {@link AlgorithmsList}<br>
 */
public final class Generator implements AdditionalFunctionalityForGeneratorArrays {
    private final int rows;
    private final int columns;
    private BaseForAlgorithm algorithm;

    public Generator(int rows, int columns, AlgorithmsList algorithms) {
        this.rows = rows;
        this.columns = columns;
        changeAlgorithmGeneration(algorithms);
    }

    public void changeAlgorithmGeneration(AlgorithmsList algorithm) {
        switch (algorithm) {
            case SPIRAL: {
                this.algorithm = new SpiralAlgorithm(rows, columns);
                break;
            }
            case  CLASSIC_FILL:{
                this.algorithm = new ClassicFillAlgorithm(rows, columns);
                break;
            }
            default:
                throw new RuntimeException("Алгоритм не включен в switch-case класса " +this.getClass());
        }
        this.algorithm.generateArray();
    }


    public void printArray() {
        this.printDefault(algorithm.getArray());
    }


    public int[][] getArray() {
        return algorithm.getArray();
    }

}
