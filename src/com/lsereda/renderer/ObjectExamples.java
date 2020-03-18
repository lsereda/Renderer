package com.lsereda.renderer;

import com.lsereda.renderer.Poly;
import com.lsereda.renderer.Vertex;

import java.awt.*;
import java.util.List;

public class ObjectExamples {

    public static void addTetrahedronPolygonsToList(List<Poly> polygons) {
        polygons.add(new Poly(Color. WHITE, new Vertex(100, 100, 100), //the second one
                new Vertex(-100, -100, 100),
                new Vertex(-100, 100, -100)));
        polygons.add(new Poly(Color.RED, new Vertex(100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(100, -100, -100)));
        polygons.add(new Poly(Color.BLUE, new Vertex(-100, 100, -100),
                new Vertex(100, -100, -100),
                new Vertex(100, 100, 100)));
        polygons.add(new Poly(Color.GREEN, new Vertex(-100, 100, -100),
                new Vertex(100, -100, -100),
                new Vertex(-100, -100, 100)));
    }
}
