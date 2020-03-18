package com.lsereda.renderer;

import com.lsereda.renderer.Panel;
import com.lsereda.renderer.Poly;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Renderer {

    private static JFrame frame;
    private static com.lsereda.renderer.Panel panel;


    public Renderer() {
        frame = new JFrame();
        configureFrame(frame);
        panel = new com.lsereda.renderer.Panel();
        configurePanel(panel);
    }

    private void configureFrame(JFrame frame) {
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void configurePanel(Panel panel) {
        panel.getPane().add(panel, BorderLayout.CENTER);
        panel.getXSlider().addChangeListener(e -> panel.repaint());
        panel.getYSlider().addChangeListener(e -> panel.repaint());
        panel.getZSlider().addChangeListener(e -> panel.repaint());
    }

    public void generatePolygons(List<Poly> args) {
        args.forEach(p -> panel.getPolygons().add(p));
    }

    public static JFrame getFrame() {
        return frame;
    }

}
