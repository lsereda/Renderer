package com.lsereda.renderer;

import javax.swing.*;
import java.awt.*;

public class Renderer {

    private static JFrame frame;
    private static Panel panel;


    public static void main(String[] args) {
        frame = new JFrame();

        frame.setSize(800, 800); //can be changed
        frame.setVisible(true);
        frame.setResizable(false);

        panel = new Panel();

        panel.getPane().add(panel, BorderLayout.CENTER);
        panel.getxSlider().addChangeListener(e -> panel.repaint());
        panel.getySlider().addChangeListener(e -> panel.repaint());
        panel.getzSlider().addChangeListener(e -> panel.repaint());


        panel.getPolygons().add(new Poly(Color.WHITE, new Vertex(100, 100, 100), //test object
                new Vertex(-100, 100, 100),
                new Vertex(-100, -100, 100),
                new Vertex(100, -100, 100)));
        panel.getPolygons().add(new Poly(Color.YELLOW, new Vertex(100, 100, -100), //TODO
                new Vertex(-100, 100, -100),
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100)));
        panel.getPolygons().add(new Poly(Color.ORANGE, new Vertex(100, 100, 100), //TODO
                new Vertex(-100, 100, 100),
                new Vertex(-100, 100, -100),
                new Vertex(100, 100, -100)));
        panel.getPolygons().add(new Poly(Color.RED, new Vertex(100, -100, 100), //TODO
                new Vertex(-100, -100, 100),
                new Vertex(-100, -100, -100),
                new Vertex(100, -100, -100)));
        panel.getPolygons().add(new Poly(Color.GREEN, new Vertex(100, 100, 100), //TODO
                new Vertex(100, -100, 100),
                new Vertex(100, -100, -100),
                new Vertex(100, 100, -100)));
        panel.getPolygons().add(new Poly(Color.BLUE, new Vertex(-100, 100, 100), //TODO
                new Vertex(-100, -100, 100),
                new Vertex(-100, -100, -100),
                new Vertex(-100, 100, -100)));

//        panel.getPolygons().add(new Poly(Color. WHITE, new Vertex(100, 100, 100), //another test object
//                new Vertex(-100, -100, 100),
//                new Vertex(-100, 100, -100)));
//        panel.getPolygons().add(new Poly(Color.RED, new Vertex(100, 100, 100),
//                new Vertex(-100, -100, 100),
//                new Vertex(100, -100, -100)));
//        panel.getPolygons().add(new Poly(Color.BLUE, new Vertex(-100, 100, -100),
//                new Vertex(100, -100, -100),
//                new Vertex(100, 100, 100)));
//        panel.getPolygons().add(new Poly(Color.GREEN, new Vertex(-100, 100, -100),
//                new Vertex(100, -100, -100),
//                new Vertex(-100, -100, 100)));
    }

    public static JFrame getFrame() {
        return frame;
    }

}
