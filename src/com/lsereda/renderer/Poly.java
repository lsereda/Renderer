package com.lsereda.renderer;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Poly {

    private List<Vertex> vertices; //every polygon has vertices array
    private Color color;


    public Poly(Color color, Vertex... args) { //constructor with variable arguments
        this.color = color;
        vertices = new LinkedList<>();
        for (Vertex v : args) {
            vertices.add(v);
        }
    }

     public Poly(List<Vertex> vertices, Color color) {
         this.vertices = vertices;
         this.color = color;
     }

     public int getVerticesQuantity() {
        return vertices.size();
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public Color getColor() {
        return color;
    }

}
