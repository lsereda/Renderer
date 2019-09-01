package com.lsereda.renderer;

import java.awt.*;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {
        Renderer renderEngine = new Renderer();
        LinkedList<Poly> polygons = new LinkedList<>();
        //test objects (do not use both of them):
//        addCubePolygonsToList(polygons);
//        addTetrahedronPolygonsToList(polygons);
        renderEngine.generatePolygons(polygons.toArray(new Poly[0]));
    }

    private static void addCubePolygonsToList(LinkedList<Poly> polygons) {
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

    private static void addTetrahedronPolygonsToList(LinkedList<Poly> polygons) {
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
