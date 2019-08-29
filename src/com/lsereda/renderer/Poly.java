package com.lsereda.renderer;

import java.awt.*;
import java.util.LinkedList;

//TODO TODO TODO TODO
public class Poly { //we assume that polygon is regular
    LinkedList<Vertex> vertices; //every polygon has vertices array
    private Color color;

    public Poly(Color color, Vertex... args) { //constructor with variable arguments
        this.color = color;

        vertices = new LinkedList<>();
        for (Vertex v : args) {
            vertices.add(v);
        }
    }

     public Poly(LinkedList<Vertex> vertices, Color color) {
         this.vertices = vertices;
         this.color = color;
     }

     public int getVerticesQuantity() {
        return vertices.size();
    }
    public LinkedList<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(LinkedList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
