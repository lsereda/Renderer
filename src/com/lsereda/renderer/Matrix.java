package com.lsereda.renderer;


public class Matrix {

    private double[][] values;

    public Matrix(int x, int y) {
        values = new double[x][y];
    }

    public Matrix(double[][] values) {
        this.values = values;
    }

    public double[][] getValues() {
        return values;
    }

}