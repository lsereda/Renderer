package com.lsereda.renderer;

import com.lsereda.renderer.Poly;
import com.lsereda.renderer.Vertex;

import java.util.Comparator;

public class PolygonCompare implements Comparator<com.lsereda.renderer.Poly> {

    public int compare (com.lsereda.renderer.Poly a, com.lsereda.renderer.Poly b) {
        return (int) (averageDepth(a) - averageDepth(b));
    }

    private double sumDepth(com.lsereda.renderer.Poly p) {
        return p.getVertices()
                .stream()
                .map(Vertex::getZ)
                .reduce(0d, Double::sum);
    }

    private double averageDepth(Poly p) {
        return sumDepth(p) / p.getVerticesQuantity();
    }

}
