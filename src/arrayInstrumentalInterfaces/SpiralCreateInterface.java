package arrayInstrumentalInterfaces;

import java.util.Optional;

/**
 * Интерфейс для алгоритмов по закручиванию в спираль массивов
 * Example:
 * generateArray(3,3) - >
 *  1 2 3
 *  8 9 4
 *  7 6 5
 */
public interface SpiralCreateInterface {
    Optional<int[][]> generateArray();
    Optional<int[][]> getSpiralArray();
}
