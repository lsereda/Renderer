package com.lsereda.renderer;

import java.util.LinkedList;
import java.util.List;

import static com.lsereda.renderer.ObjectExamples.addCubePolygonsToList;
import static com.lsereda.renderer.ObjectExamples.addTetrahedronPolygonsToList;

public class Main {


    public static void main(String[] args) {
        Renderer renderEngine = new Renderer();
        List<Poly> polygons = new LinkedList<>();
        //test objects (do not use both of them):
        addCubePolygonsToList(polygons);
//        addTetrahedronPolygonsToList(polygons);
        renderEngine.generatePolygons(polygons);
    }


}
