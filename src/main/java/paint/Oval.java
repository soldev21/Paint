package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

/**
 * Created by Sherif on 2/23/2020.
 */
public class Oval extends PaintFigure {

    int height = 30;
    int width = 30;


    public Oval(int x, int y, Color color) {
        super(x, y, color);
        setSize(new Dimension(width+1, height+1));
        setBounds(x, y, width+1, height+1);
//
    }

    private int getRadius() {
        return Math.min(width, height);
    }


    @Override
    public void paint(Graphics graphics) {
//        System.out.println("Painting");
//        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(color);
        graphics2D.fillOval(0, 0, width, height);
    }

    @Override
    public void update(Graphics graphics) {
        System.out.println("Update");
        paint(graphics);
    }


    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void resize() {

    }
}
