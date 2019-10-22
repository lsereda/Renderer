package com.lsereda.renderer;

import java.awt.*;
import java.util.List;

public class ObjectExamples {

    public static void addCubePolygonsToList(List<Poly> polygons) {
        polygons.add(new Poly(Color.WHITE, new Vertex(100, 100, 100), //the first one
                new Vertex(-100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(100, -100, 100)));
        polygons.add(new Poly(Color.YELLOW, new Vertex(100, 100, -100),
                new Vertex(-100, 100, -100),
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100)));
        polygons.add(new Poly(Color.ORANGE, new Vertex(100, 100, 100),
                new Vertex(-100, 100, 100),
                new Vertex(-100, 100, -100),
                new Vertex(100, 100, -100)));
        polygons.add(new Poly(Color.RED, new Vertex(100, -100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100)));
        polygons.add(new Poly(Color.GREEN, new Vertex(100, 100, 100),
                new Vertex(100, -100, 100),
                new Vertex(100, -100, -100),
                new Vertex(100, 100, -100)));
        polygons.add(new Poly(Color.BLUE, new Vertex(-100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(-100, -100, -100),
                new Vertex(-100, 100, -100)));
    }

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
