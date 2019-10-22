package com.lsereda.renderer;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import static com.lsereda.renderer.MatrixOperations.multiply;
import static com.lsereda.renderer.MatrixOperations.getXYRotationMatrix;
import static com.lsereda.renderer.MatrixOperations.getYZRotationMatrix;
import static com.lsereda.renderer.MatrixOperations.getXZRotationMatrix;

public class Panel extends JPanel {

    private Container pane;
    private List<Poly> polygons;
    private JSlider xSlider;
    private JSlider ySlider;
    private JSlider zSlider;


    public Panel() {
        pane = Renderer.getFrame().getContentPane();
        polygons = new LinkedList<>();
        pane.setLayout(new BorderLayout());
        configureSliders();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        double xSliderAngle = Math.toRadians(xSlider.getValue());
        double ySliderAngle = Math.toRadians(ySlider.getValue());
        double zSliderAngle = Math.toRadians(zSlider.getValue());

        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.setColor(Color.WHITE);

        List<Poly> temporaryPolygons = new LinkedList<>();
        for (Poly p : polygons) {
            List<Vertex> tempVertices = new LinkedList<>();
            for (Vertex v : p.getVertices()) {
                tempVertices.add(new Vertex(multiply(getXYRotationMatrix(zSliderAngle), getXZRotationMatrix(ySliderAngle),
                        getYZRotationMatrix(xSliderAngle), v.getVector3D())));
            }
            temporaryPolygons.add(new Poly(tempVertices, p.getColor()));
        }
        temporaryPolygons.sort(new PolygonCompare());
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

    private void configureSliders() {
        xSlider = new JSlider(-180, 180, 0);
        ySlider = new JSlider(SwingConstants.VERTICAL, -180, 180, 0);
        zSlider = new JSlider(SwingConstants.VERTICAL, -180, 180, 0);
        pane.add(xSlider, BorderLayout.SOUTH);
        pane.add(ySlider, BorderLayout.EAST);
        pane.add(zSlider, BorderLayout.WEST);
    }
    public Container getPane() {
        return pane;
    }

    public List<Poly> getPolygons() {
        return polygons;
    }

    public JSlider getxSlider() {
        return xSlider;
    }

    public JSlider getySlider() {
        return ySlider;
    }

    public JSlider getzSlider() {
        return zSlider;
    }

}
