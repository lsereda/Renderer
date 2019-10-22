package com.lsereda.renderer;

public class Vertex {


    private Matrix vector3D; //every vertex has vector of its cordinates

    public Vertex(Matrix vector) {
        this.vector3D = vector;
    }

    public Vertex(double x, double y, double z) {
        vector3D = new Matrix(new double[][] {{x}, {y}, {z}});
    }

    public Matrix getVector3D() {
        return vector3D;
    }

    public double getX() {
        return this.vector3D.getValues()[0][0];
    }

    public double getY() {
        return this.vector3D.getValues()[1][0];
    }

    public double getZ() {
        return this.vector3D.getValues()[2][0];
    }

}
