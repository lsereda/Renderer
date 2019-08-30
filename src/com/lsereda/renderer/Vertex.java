package com.lsereda.renderer;

public class Vertex {


    private Matrix vector3D; //every vertex has vector of its cordinates

    public Vertex(Matrix vector) {
        this.vector3D = vector;
    }

    public Vertex(double x, double y, double z) {
        double[][] tempVector = new double[3][1];
        tempVector[0][0] = x;
        tempVector[1][0] = y;
        tempVector[2][0] = z;
        vector3D = new Matrix(tempVector);
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
