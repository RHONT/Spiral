package converter;

import algoritmConvertArrayImpl.DefaultSpiralConverterImpl;
import arrayInstrumentalInterfaces.SpiralConverterInterface;
import arrayInstrumentalInterfaces.SpiralCreateInterface;

import java.util.Optional;

public class GenerateArray implements SpiralConverterInterface {

    private SpiralCreateInterface converter;

    public GenerateArray(int rows, int columns, ConvertersList convertersList) {
        switch (convertersList) {
            case DEFAULT: {
                converter = new DefaultSpiralConverterImpl(rows, columns);
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
        return converter.getSpiralArray().orElseThrow(
                ()->new RuntimeException("Массив не обнаружен"));
    }
}
