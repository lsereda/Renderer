package com.lsereda.renderer;

import com.lsereda.renderer.Matrix;

import java.util.Arrays;

public class MatrixOperations {

    private static com.lsereda.renderer.Matrix multiplyUtil(com.lsereda.renderer.Matrix firstMatrix, com.lsereda.renderer.Matrix secondMatrix) {
        if (emptyOrNull(firstMatrix) || emptyOrNull(secondMatrix)) {
            throw new ArithmeticException("At least one matrix is invalid matrix");
        }
        if (!canBeMultipliedCorrectly(firstMatrix, secondMatrix)) {
            throw new ArithmeticException("Wrong matrices dimensions");
        }
        final var temp = new com.lsereda.renderer.Matrix(firstMatrix.getValues().length, secondMatrix.getValues()[0].length);
        for (var i = 0; i < temp.getValues().length; i++) {
            for (var j = 0; j < temp.getValues()[0].length; j++) {
                for (var k = 0; k < firstMatrix.getValues()[0].length; k++) {
                    temp.getValues()[i][j] += firstMatrix.getValues()[i][k] * secondMatrix.getValues()[k][j];
                }
            }
        }
        return temp;
    }

    public static com.lsereda.renderer.Matrix multiply(com.lsereda.renderer.Matrix... args) {
        return Arrays.stream(args)
                     .reduce(getIdentityMatrix(args[0].getValues().length), MatrixOperations::multiplyUtil);
    }

    public static com.lsereda.renderer.Matrix getXYRotationMatrix(double angle) {
        double[][] temp =
                {{Math.cos(angle), -Math.sin(angle), 0},
                        {Math.sin(angle), Math.cos(angle), 0},
                        {0, 0, 1}};
        return new com.lsereda.renderer.Matrix(temp);
    }

    public static com.lsereda.renderer.Matrix getYZRotationMatrix(double angle) {
        double[][] temp =
                {{1, 0, 0},
                        {0, Math.cos(angle), -Math.sin(angle)},
                        {0, Math.sin(angle), Math.cos(angle)}};
        return new com.lsereda.renderer.Matrix(temp);
    }

    public static com.lsereda.renderer.Matrix getXZRotationMatrix(double angle) {
        double[][] temp =
                {{Math.cos(angle), 0, Math.sin(angle)},
                        {0, 1, 0},
                        {-Math.sin(angle), 0, Math.cos(angle)}};
        return new com.lsereda.renderer.Matrix(temp);
    }

    public static com.lsereda.renderer.Matrix getIdentityMatrix(int size) {
        final var temp = new com.lsereda.renderer.Matrix(size, size);
        for (var i = 0; i < size; i++) {
            for (var j = 0; j < size; j++) {
                if (i == j) {
                    temp.getValues()[i][j] = 1;
                }
            }
        }
        return temp;
    }

    private static boolean canBeMultipliedCorrectly(com.lsereda.renderer.Matrix a, com.lsereda.renderer.Matrix b) {
        return a.getValues()[0].length == b.getValues().length;
    }

    private static boolean emptyOrNull(Matrix m) {
        return m.getValues() == null || m.getValues().length == 0 || m.getValues()[0].length == 0;
    }
}
