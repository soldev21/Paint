package view;

import paint.PaintFigure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DrawingPanel extends JPanel {

    public DrawingPanel(){

        setPreferredSize(new Dimension(1000,600));
        setBackground(Color.WHITE);
        addMouseMotionListener(new CustomMouseMotionListener());
        addMouseListener(new CustomMouseListener());
        setLayout(null);
    }

    private class CustomMouseMotionListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println(String.format("Resize : x=%d y=%d",e.getX(),e.getY()));
            paint.Painter.resize(e.getX(),e.getY());
        }
    }

    private class CustomMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            requestFocus();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println(String.format("Initial : x=%d y=%d",e.getX(),e.getY()));
            PaintFigure figure = paint.Painter.init(e.getX(),e.getY());
            add(figure);
            repaint();
        }
    }
}
