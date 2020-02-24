package paint;

import view.ColorButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by s.huseynli on 2/23/2020.
 */
public abstract class PaintComponent extends JPanel {
    protected int x;
    protected int y;
    protected Color color;

    public void changeColor(Color color){
        this.color = color;
        repaint();
    }
}
