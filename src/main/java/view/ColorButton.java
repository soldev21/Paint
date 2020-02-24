package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorButton extends JButton {

    Color color;
    boolean isSelected;
    JButton button;

    public ColorButton (Color color){



        this.color=color;
        this.isSelected=false;
        this.setBackground(color);
        this.addMouseListener(new MouseHandler());
        this.setPreferredSize(new Dimension(80,50));
        this.setLocation(20,20);

    }


    private class MouseHandler extends MouseAdapter
    {
        public void mousePressed(MouseEvent event)          //when the mouse button is pressed
        {
//            Main.paint.colorPalette.deselectAll();          //deselect all colors
            isSelected = true;                                //set the current selectedColor to isSelected
//            Main.paint.drawingPanel.setCurrentColor(color);      //set the brush selectedColor of the draw panel to the isSelected selectedColor
//            ColorPalette.selectedColorDisplay.setBackground(color);  //set the selectedColor of the selectedColorDisplay
//            Main.paint.repaint();                            //repaint the main application window
        }
        public void mouseReleased(MouseEvent mouseevent){ }

        public void mouseClicked(MouseEvent mouseevent) {}

        public void mouseEntered(MouseEvent mouseevent){ }

    }


}
