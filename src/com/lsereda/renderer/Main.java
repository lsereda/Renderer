package com.lsereda.renderer;

import com.lsereda.renderer.Poly;
import com.lsereda.renderer.Renderer;

import java.util.ArrayList;

import static com.lsereda.renderer.ObjectExamples.addTetrahedronPolygonsToList;

public class Main {

    public static void main(String[] args) {
        final var renderEngine = new Renderer();
        final var polygons = new ArrayList<Poly>();
        addTetrahedronPolygonsToList(polygons);
        renderEngine.generatePolygons(polygons);
    }

}