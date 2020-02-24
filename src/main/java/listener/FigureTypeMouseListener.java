package listener;

import paint.PaintFigure;
import paint.Painter;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Sherif on 2/24/2020.
 */
public class FigureTypeMouseListener extends MouseAdapter {

    private PaintFigure.Figure figure;

    public FigureTypeMouseListener(PaintFigure.Figure figure){
        this.figure = figure;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Painter.setFigure(figure);
    }
}
