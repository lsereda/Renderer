package com.lsereda.renderer;

import com.lsereda.renderer.Poly;
import com.lsereda.renderer.PolygonCompare;
import com.lsereda.renderer.Renderer;
import com.lsereda.renderer.Vertex;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
        polygons = new ArrayList<>();
        pane.setLayout(new BorderLayout());
        configureSliders();
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        final var xSliderAngle = Math.toRadians(xSlider.getValue());
        final var ySliderAngle = Math.toRadians(ySlider.getValue());
        final var zSliderAngle = Math.toRadians(zSlider.getValue());

        g2.translate(getWidth() / 2, getHeight() / 2);
        g2.setColor(Color.WHITE);

        final var temporaryPolygons = applyRotations(polygons, xSliderAngle, ySliderAngle, zSliderAngle);
        temporaryPolygons.sort(new PolygonCompare());
        drawPolygons(temporaryPolygons, g);
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

    public JSlider getXSlider() {
        return xSlider;
    }

    public JSlider getYSlider() {
        return ySlider;
    }

    public JSlider getZSlider() {
        return zSlider;
    }

    public static List<Poly> applyRotations(List<Poly> polygons, double xSliderAngle,
                                            double ySliderAngle, double zSliderAngle) {
        final var result = new ArrayList<Poly>();
        for (var p : polygons) {
            final var tempVertices = new ArrayList<Vertex>();
            for (var v : p.getVertices()) {
                tempVertices.add(new Vertex(multiply(getXYRotationMatrix(zSliderAngle),
                        getXZRotationMatrix(ySliderAngle), getYZRotationMatrix(xSliderAngle), v.getCoordinates())));
            }
            result.add(new Poly(tempVertices, p.getColor()));
        }
        return result;
    }

    private void drawPolygons(List<Poly> polygons, Graphics g) {
        for (var p : polygons) {
            var polygon = new Polygon();
            for (var v : p.getVertices()) {
                polygon.addPoint((int) v.getX(), (int) v.getY());
            }
            g.setColor(p.getColor());
            g.fillPolygon(polygon);
            g.setColor(Color.BLACK);
            g.drawPolygon(polygon);
        }
    }

}
