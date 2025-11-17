package org.example;

import java.util.*;

public class StatisticsCalculator {

    public static void compute(double[] x, double[] p) {
        double mean = 0;
        double ex2 = 0;

        for (int i = 0; i < x.length; i++) {
            mean += x[i] * p[i];
            ex2 += x[i] * x[i] * p[i];
        }

        double variance = ex2 - mean * mean;
        if (variance < 0 && variance > -1e-12) variance = 0;

        double sigma = Math.sqrt(variance);

        double maxP = Arrays.stream(p).max().getAsDouble();
        List<Double> modes = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            if (Math.abs(p[i] - maxP) < 1e-12)
                modes.add(x[i]);
        }

        System.out.println("M(X) = " + mean);
        System.out.println("D(X) = " + variance);
        System.out.println("σ(X) = " + sigma);
        System.out.println("Мода = " + modes);
    }
}