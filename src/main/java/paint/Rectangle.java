package paint;

import java.awt.*;
import java.awt.event.MouseEvent;

import static util.Utility.PointUtil.*;


/**
 * Created by Sherif on 2/23/2020.
 */
public class Rectangle extends PaintFigure {

    int height;
    int width;

    public Rectangle(Point point,Color color){
        this(point.x,point.y,color);
    }

    public Rectangle(int x, int y, Color color) {
        super(x, y, color);
        setSize(new Dimension(width + 1, height + 1));
        setBounds(x, y, width + 1, height + 1);
    }


    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setColor(color);
//        graphics2D.drawOval(0, 0, width, height);
        graphics2D.drawRect(0, 0, width, height);
    }

    @Override
    public void update(Graphics graphics) {
        paintComponent(graphics);
    }



    @Override
    public void fill(Color color) {
//        currentAction= Action.FILL;
        update(getGraphics());
    }

    @Override
    public void resizeItem(int x,int y) {
        width = getW(this.x,x);
        height = getH(this.y,y);
        if (width>0 && height>0) {
            setSize(new Dimension(width + 1, height + 1));
            setBounds(this.x, this.y, width + 1, height + 1);
            repaint();
        }
    }
}
