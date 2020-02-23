package paint;

import javax.swing.*;

/**
 * Created by Sherif on 2/23/2020.
 */
public class Paint extends JFrame{

    private static int MAIN_WIDTH=500;
    private static int MAIN_HEIGHT = 300;

    public Paint(){
        super();
        init();
//        this.pack();
        this.setVisible(true);
    }

    private void init(){
        this.setSize(MAIN_WIDTH,MAIN_HEIGHT);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setLayout(null);
        MyCanvas myCanvas = new MyCanvas();
        getContentPane().add(myCanvas);
    }
}
