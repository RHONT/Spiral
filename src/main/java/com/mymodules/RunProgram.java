package com.mymodules;

import com.mymodules.algoritmConvertArrayImpl.enumAlgorithm.AlgorithmsList;
import com.mymodules.generator.Generator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RunProgram {
    static int rows;
    static int column;
    static int inputNumberAlgorithm;
    static Scanner scanner = new Scanner(System.in);
    static String errorMsgAlgorithm = "Номер алгоритма введен неверно. Повторите ввод";
    static String errorMsgDigit = "Поддерживается только ввод цифр. Повторите ввод";
    static Set<Integer> setDigitAlgorithm = new HashSet<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Выберите алгоритм генерации массива");
            printAlgorithm();
            inputNumberAlgorithm = checkInputDigitOfAlgorithm(scanner.nextLine());
            System.out.println("Введите кол-во строк");
            rows = checkAndTakeDigit(scanner.nextLine());
            System.out.println("Введите кол-во столбцов");
            column = checkAndTakeDigit(scanner.nextLine());
            Generator generator = Generator.createDefault(rows, column, AlgorithmsList.values()[inputNumberAlgorithm]);
            System.out.println(generator.TextStatement());
            System.out.println("Для выхода из приложения введите -1, для продолжения любую другую цифру");
            checkAndTakeDigit(scanner.nextLine());
        }
    }

    private static int checkAndTakeDigit(String value) {
        String tempString = value;
        while (true) {
            try {
                int temp = Integer.parseInt(tempString);
                if (temp == -1) {
                    System.exit(0);
                }
                return temp;
            } catch (NumberFormatException e) {
                System.out.println(errorMsgDigit);
                tempString = scanner.nextLine();
            }
        }
    }

    private static int checkInputDigitOfAlgorithm(String value) {
        String tempString = value;
        while (true) {
            int checkDigit = checkAndTakeDigit(tempString);
            if (setDigitAlgorithm.contains(checkDigit)) {
                return checkDigit;
            } else {
                System.out.println(errorMsgAlgorithm);
                tempString = scanner.nextLine();
            }
        }
    }

    private static void printAlgorithm() {
        for (var element : AlgorithmsList.values()) {
            setDigitAlgorithm.add(element.ordinal());
            System.out.println(element.ordinal() + " - " + element.name());
        }
    }
}
