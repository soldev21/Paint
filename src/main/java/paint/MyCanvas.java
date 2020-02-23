package paint;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Sherif on 2/23/2020.
 */
public class MyCanvas extends Canvas implements MouseListener,MouseMotionListener{

    private boolean show = true;
    int x = 20;
    int y = 20;
    int x1 =x;
    int y1 =y;
    int height = 100;
    int width = 150;

    public MyCanvas(){
        super();
        setBounds(x,y,width,height);
//        setSize(width,height);
//        addMouseListener(this);
        addMouseMotionListener(this);
    }



    @Override
    public void paint(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D)  graphics;
        graphics2D.setColor(Color.RED);
        graphics2D.fillRect(x1,y1,30,30);
    }

    @Override
    public void update(Graphics graphics){
        paint(graphics);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setVisible(!show);
        show=!show;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x1=e.getX();
        y1=e.getY();
        getGraphics().clearRect(x,y,width,height);
        repaint();
        x=x1;
        y=y1;
    }
}
