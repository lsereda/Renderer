package com.lsereda.renderer;

import javax.swing.*;
import java.awt.*;

public class Renderer {

    private static JFrame frame;
    private static Panel panel;


    public Renderer() {
        frame = new JFrame();
        configureFrame(frame);
        panel = new Panel();
        configurePanel(panel);
    }

    private void configureFrame(JFrame frame) {
        frame.setSize(800, 800); //can be changed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void configurePanel(Panel panel) {
        panel.getPane().add(panel, BorderLayout.CENTER);
        panel.getxSlider().addChangeListener(e -> panel.repaint());
        panel.getySlider().addChangeListener(e -> panel.repaint());
        panel.getzSlider().addChangeListener(e -> panel.repaint());
    }

    public void generatePolygons(Poly... args) {
        for (Poly p : args) {
            panel.getPolygons().add(p);
        }
    }
    public static JFrame getFrame() {
        return frame;
    }

}
