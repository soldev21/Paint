package listener;

import paint.Painter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Sherif on 2/24/2020.
 */
public class ColorButtonMouseListener extends MouseAdapter {

    private Color color;

    public ColorButtonMouseListener(Color color){
        this.color = color;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Painter.setColor(color);
        Painter.changeFigureColor();
    }
}
