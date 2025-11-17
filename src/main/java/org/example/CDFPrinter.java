package org.example;

public class CDFPrinter {

    public static void print(double[] x, double[] p) {
        System.out.println("\nCDF:");
        double cum = 0;
        for (int i = 0; i < x.length; i++) {
            cum += p[i];
            System.out.println("F(" + x[i] + ") = " + cum);
        }
    }
}