package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static paint.FigureFactory.getNewFigure;

/**
 * Created by Sherif on 2/23/2020.
 */
public class Paint extends JFrame {

    private static int MAIN_WIDTH=500;
    private static int MAIN_HEIGHT = 300;

    public Paint(){
        super();
        init();
        this.setVisible(true);
    }

    private void init(){
        this.setSize(MAIN_WIDTH,MAIN_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        this.setLayout(null);
        addMouseMotionListener(new CustomMouseMotionListener());
        addMouseListener(new CustomMouseListener());
    }

    private class CustomMouseMotionListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            System.out.println(String.format("Resize : x=%d y=%d",e.getX(),e.getY()));
            Painter.resize(e.getX(),e.getY());
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
            PaintFigure figure = Painter.init(e.getX(),e.getY());
            getContentPane().add(figure);
            repaint();
        }
    }
}
