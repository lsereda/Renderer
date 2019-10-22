package com.lsereda.renderer;

import java.util.Comparator;

public class PolygonCompare implements Comparator<Poly> {

    public int compare (Poly a, Poly b) {
        double averageADepth = a.getVertices().stream().map(Vertex::getZ).reduce(0d, Double::sum);
        averageADepth /= a.getVerticesQuantity();
        double averageBDepth = b.getVertices().stream().map(Vertex::getZ).reduce(0d, Double::sum);
        averageBDepth /= b.getVerticesQuantity();
        return (int) (averageADepth - averageBDepth);
    }

}
