package com.lsereda.renderer;

import com.lsereda.renderer.Vertex;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Poly {

    private List<Vertex> vertices;
    private Color color;


    public Poly(Color color, Vertex... args) {
        this.color = color;
        vertices = new ArrayList<>();
        vertices.addAll(Arrays.asList(args));
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
