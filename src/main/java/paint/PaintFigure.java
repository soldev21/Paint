package paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static util.Utility.CursorFactory.DEFAULT_CURSOR;

/**
 * Created by s.huseynli on 2/23/2020.
 */
public abstract class PaintFigure extends PaintComponent implements MouseListener, MouseMotionListener, Resizable {

    private int clickedX;
    private int clickedY;
    protected Map<Integer,Map<Integer,Point>> resizablePoints;

    public PaintFigure(int x, int y, Color color){
        resizablePoints = new HashMap<>();
        this.x = x;
        this.y = y;
        this.color = color;
        setOpaque(false);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        resize();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("PRESSED");
        clickedX = e.getXOnScreen();
        clickedY = e.getYOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(DEFAULT_CURSOR);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int newX = e.getXOnScreen();
        int newY = e.getYOnScreen();
        x = (int)getLocation().getX() + (newX-clickedX);
        y = (int)getLocation().getY() + (newY-clickedY);
        setLocation(x, y);
        clickedX=newX;
        clickedY=newY;

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    private Point getResizablePoint(int x,int y){
        Map<Integer,Point> map;
        if (Objects.nonNull(map=resizablePoints.get(x))){
            return map.get(y);
        }
        return null;
    }
}
