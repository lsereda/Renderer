package com.lsereda.renderer;

public class Vertex {

    private Matrix vector; //every vertex has vector of its cordinates

    public Vertex() {
    }

    public Vertex(Matrix vector) {
        this.vector = vector;
    }

    public Vertex(double x, double y, double z) {
        double[][] tempVector = new double[3][1];
        tempVector[0][0] = x;
        tempVector[1][0] = y;
        tempVector[2][0] = z;
        vector = new Matrix(tempVector);
    }

    public Matrix getVector() {
        return vector;
    }

    public void setVector(Matrix vector) {
        this.vector = vector;
    }

    public double getX() {
        return this.vector.getValues()[0][0];
    }

    public double getY() {
        return this.vector.getValues()[1][0];
    }

    public double getZ() {
        return this.vector.getValues()[2][0];
    }

}
