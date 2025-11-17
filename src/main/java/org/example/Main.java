package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        double[] x = {0, 1, 2, 3};
        String[] pInput = {"p", "0.2", "0.1", "0.2"};

        System.out.println("Вхідний ряд:");
        System.out.println("X = " + Arrays.toString(x));
        System.out.println("P (вхід) = " + Arrays.toString(pInput));

        double[] p = ProbabilityParser.parse(pInput);

        System.out.println("\nПісля обчислення:");
        System.out.println("P = " + Arrays.toString(p));

        System.out.println("\nЧислові характеристики:");
        StatisticsCalculator.compute(x, p);

        CDFPrinter.print(x, p);
    }
}