package generatorarray;

import algoritmConvertArrayImpl.AlgorithmGenerateArray;
import algoritmConvertArrayImpl.ClassicFillAlgorithmGenerateArray;
import algoritmConvertArrayImpl.SpiralAlgorithmGenerateArray;
import algoritmConvertArrayImpl.AlgorithmsList;
import arrayinstrumentalinterfaces.AdditionalFunctionalityForGeneratorArrays;

/**
 * Фабрика + Bridge. Где: <br>
 * Мост выступает - {@link AlgorithmGenerateArray}<br>
 * Фабрика: фабричный метод changeAlgorithmGeneration()<br>
 *
 * Конструктор принимает размерность массива и алгоритм из {@link AlgorithmsList}<br>
 */
public final class Generator implements AdditionalFunctionalityForGeneratorArrays {
    private final int rows;
    private final int columns;
    private AlgorithmGenerateArray algorithm;

    public Generator(int rows, int columns, AlgorithmsList algorithmsType) {
        this.rows = rows;
        this.columns = columns;
        changeAlgorithmGeneration(algorithmsType);
    }

    public void changeAlgorithmGeneration(AlgorithmsList algorithm) {
        switch (algorithm) {
            case SPIRAL: {
                this.algorithm = new SpiralAlgorithmGenerateArray(rows, columns);
                break;
            }
            case  CLASSIC_FILL:{
                this.algorithm = new ClassicFillAlgorithmGenerateArray(rows, columns);
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
