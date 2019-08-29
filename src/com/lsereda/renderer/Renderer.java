package com.lsereda.renderer;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;

public class Renderer {
    public static JFrame frame;
    public static JPanel panel;
    public static Container pane;
    public static LinkedList<Poly> polygons;

    public static void main(String[] args) {
        frame = new JFrame();
        pane = frame.getContentPane();
        polygons = new LinkedList<>();
        pane.setLayout(new BorderLayout());


        JSlider xSlider = new JSlider(-180, 180, 0); //TODO
        JSlider ySlider = new JSlider(SwingConstants.VERTICAL, -180, 180, 0);
        JSlider zSlider = new JSlider(SwingConstants.VERTICAL, -180, 180, 0);

        pane.add(xSlider, BorderLayout.SOUTH);
        pane.add(ySlider, BorderLayout.EAST);
        pane.add(zSlider, BorderLayout.WEST);

        polygons.add(new Poly(Color.WHITE, new Vertex(100, 100, 100), //TODO testowy szescian
                new Vertex(-100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(100, -100, 100)));
        polygons.add(new Poly(Color.YELLOW, new Vertex(100, 100, -100), //TODO
                new Vertex(-100, 100, -100),
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100)));
        polygons.add(new Poly(Color.ORANGE, new Vertex(100, 100, 100), //TODO
                new Vertex(-100, 100, 100),
                new Vertex(-100, 100, -100),
                new Vertex(100, 100, -100)));
        polygons.add(new Poly(Color.RED, new Vertex(100, -100, 100), //TODO
                new Vertex(-100, -100, 100),
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100)));
        polygons.add(new Poly(Color.GREEN, new Vertex(100, 100, 100), //TODO
                new Vertex(100, -100, 100),
                new Vertex(100, -100, -100),
                new Vertex(100, 100, -100)));
        polygons.add(new Poly(Color.BLUE, new Vertex(-100, 100, 100), //TODO
                new Vertex(-100, -100, 100),
                new Vertex(-100, -100, -100),
                new Vertex(-100, 100, -100)));



//        polygons.add(new Poly(Color. WHITE, new Vertex(100, 100, 100), //TODO testowy czworoscian
//                new Vertex(-100, -100, 100),
//                new Vertex(-100, 100, -100)));
//        polygons.add(new Poly(Color.RED, new Vertex(100, 100, 100),
//                new Vertex(-100, -100, 100),
//                new Vertex(100, -100, -100)));
//        polygons.add(new Poly(Color.BLUE, new Vertex(-100, 100, -100),
//                new Vertex(100, -100, -100),
//                new Vertex(100, 100, 100)));
//        polygons.add(new Poly(Color.GREEN, new Vertex(-100, 100, -100),
//                new Vertex(100, -100, -100),
//                new Vertex(-100, -100, 100)));


        panel = new JPanel() { //TODO remove
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());



                double xSliderAngle = Math.toRadians(xSlider.getValue());
                double ySliderAngle = Math.toRadians(ySlider.getValue());
                double zSliderAngle = Math.toRadians(zSlider.getValue());


                g2.translate(getWidth() / 2, getHeight() / 2);
                g2.setColor(Color.WHITE);

                LinkedList<Poly> temporaryPolygons = new LinkedList<>();
                for (Poly p : polygons) { //drawing all edges !
                    LinkedList<Vertex> tempVertices = new LinkedList<>();
                    for (Vertex v : p.getVertices()) {
                        Matrix rotationMatrix = Matrix.multiply(
                                Matrix.multiply(
                                        Matrix.XYRotationMatrix(zSliderAngle), Matrix.XZRotationMatrix(ySliderAngle)
                                ),
                                Matrix.YZRotationMatrix(xSliderAngle)
                        );
                        tempVertices.add(new Vertex(Matrix.multiply(rotationMatrix, v.getVector())));
                    }
                    temporaryPolygons.add(new Poly(tempVertices, p.getColor()));
                }
                Collections.sort(temporaryPolygons, new PolygonCompare()); //TODO
                for (Poly p : temporaryPolygons) {
                    Polygon polygon = new Polygon();
                    for (Vertex v : p.getVertices()) {
                        polygon.addPoint((int) v.getX(), (int) v.getY());
                    }
                    g.setColor(p.getColor());
                    g.fillPolygon(polygon);
                    g.setColor(Color.BLACK);
                    g.drawPolygon(polygon);
                }
            }
        };

        pane.add(panel, BorderLayout.CENTER); //TODO

        xSlider.addChangeListener(e -> panel.repaint());
        ySlider.addChangeListener(e -> panel.repaint());
        zSlider.addChangeListener(e -> panel.repaint());

        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
