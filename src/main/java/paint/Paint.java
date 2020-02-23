package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * Created by Sherif on 2/23/2020.
 */
public class Paint extends JFrame implements MouseMotionListener{

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
        this.setLayout(null);
        initWithDrawings();
        addMouseMotionListener(this);
    }

    public void initWithDrawings(){
        Oval oval = new Oval(10,10, Color.BLUE);
        Oval oval2 = new Oval(30,30, Color.CYAN);
        Oval oval3 = new Oval(50,50, Color.RED);
        getContentPane().add(oval);
        getContentPane().add(oval2);
        getContentPane().add(oval3);
//        Circle circle = new Circle(15,25);
//        Circle circle2 = new Circle(40,50);
//        getContentPane().add(circle);
//        getContentPane().add(circle2);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
//        System.out.println(e.getX()+" "+e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
