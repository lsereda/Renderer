package com.lsereda.renderer;

import java.util.Comparator;

public class PolygonCompare implements Comparator<Poly> {

    public int compare (Poly a, Poly b) {
        double averageADepth = 0;
        for (Vertex v : a.getVertices()) {
            averageADepth += v.getZ();

        }
        averageADepth /= a.getVerticesQuantity();
        double averageBDepth = 0;
        for (Vertex v : b.getVertices()) {
            averageBDepth += v.getZ();
        }
        averageBDepth /= b.getVerticesQuantity();
        return (int) (averageADepth - averageBDepth);
    }

}
