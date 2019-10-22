package com.lsereda.renderer;

import java.util.Arrays;

public class MatrixOperations {

    private static Matrix multiplyUtil (Matrix firstArgument, Matrix secondArgument) { //simple matrices multiplication
        if (firstArgument.getValues() == null || secondArgument.getValues() == null //checking if matrices exists and have
                || firstArgument.getValues().length == 0 || secondArgument.getValues().length == 0 //dimensions NxN where N is natural numbers without zero
                || firstArgument.getValues()[0].length == 0 || secondArgument.getValues()[0].length == 0) {
            throw new ArithmeticException("Wrong matrices dimensions");
        }
        if (firstArgument.getValues()[0].length != secondArgument.getValues().length) { //checking if matrices dimensions are NxM and MxK, where N, M, K are natural numbers and don't equal zero
            throw new ArithmeticException("Wrong matrices dimensions");
        }
        Matrix temp = new Matrix(firstArgument.getValues().length, secondArgument.getValues()[0].length); //multiplication algorithm
        for (int i = 0; i < temp.getValues().length; i++) {
            for (int j = 0; j < temp.getValues()[0].length; j++) {
                for (int k = 0; k < firstArgument.getValues()[0].length; k++) {
                    temp.getValues()[i][j] += firstArgument.getValues()[i][k] * secondArgument.getValues()[k][j];
                }
            }
        }
        return temp;
    }

    public static Matrix multiply(Matrix... args) {
        return Arrays.stream(args).reduce(getidentityMatrix(args[0].getValues().length), (a, b) ->
                {
                    Matrix temp = new Matrix();
                    try {
                        temp = multiplyUtil(a,b);
                    }
                    catch (ArithmeticException ex) {
                        System.out.println(ex.getMessage());
                    }
                    return temp;
                }
        );
    }

    public static Matrix getXYRotationMatrix(double angle) { //method to return rotation matrix of rotation around Z axis
        double[][] temp = {{Math.cos(angle), -Math.sin(angle), 0},
                {Math.sin(angle), Math.cos(angle), 0},
                {0, 0, 1}};
        return new Matrix(temp);
    }

    public static Matrix getYZRotationMatrix(double angle) { //method to return rotation matrix of rotation around X axis
        double[][] temp = {{1, 0, 0},
                {0, Math.cos(angle), -Math.sin(angle)},
                {0, Math.sin(angle), Math.cos(angle)}};
        return new Matrix(temp);
    }

    public static Matrix getXZRotationMatrix(double angle) { //method to return rotation matrix of rotation around Y axis
        double[][] temp = {{Math.cos(angle), 0, Math.sin(angle)},
                {0, 1, 0},
                {-Math.sin(angle), 0, Math.cos(angle)}};
        return new Matrix(temp);
    }

    public static Matrix getidentityMatrix(int size) {
        Matrix temp = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    temp.getValues()[i][j] = 1;
                }
            }
        }
        return temp;
    }
}
