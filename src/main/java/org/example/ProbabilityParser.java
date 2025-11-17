package org.example;

import java.util.*;

public class ProbabilityParser {

    public static double[] parse(String[] input) {
        int pIndex = -1;
        double sumKnown = 0;

        for (int i = 0; i < input.length; i++) {
            String v = input[i].trim().toLowerCase();
            if (v.equals("p")) {
                if (pIndex != -1)
                    throw new RuntimeException("Дозволяється лише одна невідома ймовірність 'p'.");
                pIndex = i;
            } else {
                sumKnown += Double.parseDouble(v);
            }
        }

        double[] result = new double[input.length];

        if (pIndex == -1) {
            if (Math.abs(sumKnown - 1.0) > 1e-9)
                throw new RuntimeException("Сума ймовірностей != 1. Сума = " + sumKnown);
            for (int i = 0; i < input.length; i++)
                result[i] = Double.parseDouble(input[i]);
            return result;
        }

        double pValue = 1.0 - sumKnown;
        if (pValue < -1e-12)
            throw new RuntimeException("Неможливо знайти p: сума відомих ймовірностей > 1.");

        for (int i = 0; i < input.length; i++) {
            result[i] = (i == pIndex) ? pValue : Double.parseDouble(input[i]);
        }

        return result;
    }
}