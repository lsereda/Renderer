package com.lsereda.renderer;

public class Matrix { //class to store matrices

    private double[][] values;


    public Matrix() {

    }

    public Matrix(int x, int y) {
        values = new double[x][y];
    }

    public Matrix(double[][] values) {
        this.values = values;
    }

    public double[][] getValues() {
        return values;
    }


    public static Matrix multiply (Matrix firstArgument, Matrix secondArgument) { //simple matrices multiplication
        if (firstArgument.getValues() == null || secondArgument.getValues() == null //checking if matrices exists and have
                || firstArgument.getValues().length == 0 || secondArgument.getValues().length == 0 //dimensions NxN where N is natural numbers without zero
                || firstArgument.getValues()[0].length == 0 || secondArgument.getValues()[0].length == 0) {
            return new Matrix();
        }
        if (firstArgument.getValues()[0].length != secondArgument.getValues().length) { //checking if matrices dimensions are NxM and MxK, where N, M, K are natural numbers and don't equal zero
            return new Matrix();
        }
        Matrix temp = new Matrix(firstArgument.getValues().length, secondArgument.getValues()[0].length); //multiplication algorithm
        for (int i = 0; i < temp.getValues().length; i++) {
            for (int j = 0; j < temp.getValues()[0].length; j++) {
                for (int k = 0; k < firstArgument.getValues()[0].length; k++) {
                    temp.values[i][j] += firstArgument.getValues()[i][k] * secondArgument.getValues()[k][j];
                }
            }
        }
        return temp;
    }

    public static Matrix XYRotationMatrix(double angle) { //method to return rotation matrix of rotation around Z axis
        double[][] temp = {{Math.cos(angle), -Math.sin(angle), 0},
                            {Math.sin(angle), Math.cos(angle), 0},
                            {0, 0, 1}};
        return new Matrix(temp);
    }

    public static Matrix YZRotationMatrix(double angle) { //method to return rotation matrix of rotation around X axis
        double[][] temp = {{1, 0, 0},
                {0, Math.cos(angle), -Math.sin(angle)},
                {0, Math.sin(angle), Math.cos(angle)}};
        return new Matrix(temp);
    }

    public static Matrix XZRotationMatrix(double angle) { //method to return rotation matrix of rotation around Y axis
        double[][] temp = {{Math.cos(angle), 0, Math.sin(angle)},
                {0, 1, 0},
                {-Math.sin(angle), 0, Math.cos(angle)}};
        return new Matrix(temp);
    }

}
