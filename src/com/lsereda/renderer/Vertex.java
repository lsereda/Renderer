package com.lsereda.renderer;

import com.lsereda.renderer.Matrix;

public class Vertex {


    private com.lsereda.renderer.Matrix coordinates;

    public Vertex(com.lsereda.renderer.Matrix vector) {
        this.coordinates = vector;
    }

    public Vertex(double x, double y, double z) {
        coordinates = new com.lsereda.renderer.Matrix(new double[][] {{x}, {y}, {z}});
    }

    public Matrix getCoordinates() {
        return coordinates;
    }

    public double getX() {
        return this.coordinates.getValues()[0][0];
    }

    public double getY() {
        return this.coordinates.getValues()[1][0];
    }

    public double getZ() {
        return this.coordinates.getValues()[2][0];
    }

}
