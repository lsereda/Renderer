package com.lsereda.renderer;

import java.util.Comparator;

public class PolygonCompare implements Comparator<Poly> {

    public int compare (Poly a, Poly b) {
        double averageADepth = 0;
        for (Vertex vA : a.getVertices()) {
            averageADepth += vA.getZ();
        }
        averageADepth /= a.getVerticesQuantity();
        double averageBDepth = 0;
        for (Vertex vB : b.getVertices()) {
            averageBDepth += vB.getZ();
        }
        averageBDepth /= b.getVerticesQuantity();
        return (int) (averageADepth - averageBDepth);
    }
}
