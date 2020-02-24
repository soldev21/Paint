package paint;

import com.sun.org.apache.regexp.internal.RE;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static util.Utility.CursorFactory.DEFAULT_CURSOR;

/**
 * Created by s.huseynli on 2/23/2020.
 */
public abstract class PaintFigure extends PaintComponent implements Resizable {

    private int clickedX;
    private int clickedY;
    protected Map<Integer, Map<Integer, Point>> resizablePoints;
    protected Map<Action, Runnable> actions;
    protected Action currentAction;
    private PaintFigure this_;
    private static int counter;
    private int number;

    public PaintFigure(Point point, Color color) {
        this(point.x, point.y, color);
    }

    public PaintFigure(int x, int y, Color color) {
        setCurrentAction(Action.DRAW);
        resizablePoints = new HashMap<>();
        actions = new HashMap<>();
        this.x = x;
        this.y = y;
        this.color = color;
        setOpaque(false);
        setFocusable(true);
        addMouseListener(new CustomMouseListener());
        addMouseMotionListener(new CustomMouseMotionListener());
        addKeyListener(new MyKeyAdapter());
        addFocusListener(new MyFocusListener());
        this_ = this;
        number = ++counter;
    }

    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("Key PRESSED :" + number + " " + e.getKeyCode());
            if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                Container parent = getParent();
                parent.remove(this_);
                parent.repaint();
                parent.requestFocus();
            }
        }
    }

    private class MyFocusListener extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("Focus Gained: " + number);
            setBorder();
            Painter.setPaintFigure(this_);
        }

        /**
         * Invoked when a component loses the keyboard focus.
         */
        @Override
        public void focusLost(FocusEvent e) {
            System.out.println("Focus Lost: " + number);
            setBorder(null);
            Painter.setPaintFigure(null);
        }
    }


    private class CustomMouseMotionListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            int newX = e.getXOnScreen();
            int newY = e.getYOnScreen();
            x = (int) getLocation().getX() + (newX - clickedX);
            y = (int) getLocation().getY() + (newY - clickedY);
            setLocation(x, y);
            clickedX = newX;
            clickedY = newY;

        }
    }

    private class CustomMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Figure Clicked: " + number);
            requestFocusInWindow(true);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            clickedX = e.getXOnScreen();
            clickedY = e.getYOnScreen();
        }


        @Override
        public void mouseEntered(MouseEvent e) {
            setBorder();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setCursor(DEFAULT_CURSOR);
            if (!isFocusOwner()) setBorder(null);
            repaint();
        }

    }


    public void setCurrentAction(Action currentAction) {
        this.currentAction = currentAction;
    }

    public abstract void fill(Color color);

    private Point getResizablePoint(int x, int y) {
        Map<Integer, Point> map;
        if (Objects.nonNull(map = resizablePoints.get(x))) {
            return map.get(y);
        }
        return null;
    }

    private void setBorder() {
        setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
    }


    public enum Figure {
        OVAL,
        RECTANGLE
    }

    public enum Action {
        DRAW,
        RESIZE,
        FILL
    }



}
