package main;

/**
 * Created by Sherif on 2/24/2020.
 */
import listener.ColorButtonMouseListener;
import listener.FigureTypeMouseListener;
import paint.PaintFigure;
import view.ColorButton;
import view.DrawingPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

import static java.awt.BorderLayout.NORTH;

public class MainClass extends JFrame{

    public MainClass() {

        JFrame frame = this;


        frame.setResizable(false);


        JPanel panel1 = new JPanel();


        panel1.setLayout(new GridLayout(1, 3));

//        JPanel panel1_1 = new JPanel();
        JPanel panel1_2 = new JPanel();
        JPanel panel1_3 = new JPanel();
        JPanel panel1_4 = new JPanel();

//        panel1_4.setLayout(GridLayout);

//        panel1.add(panel1_1);
        panel1.add(panel1_2);
        panel1.add(panel1_3);
        panel1.add(panel1_4);


//        panel1_4.setBackground(Color.lightGray);


        ColorButton white = new ColorButton(Color.white);
        ColorButton black = new ColorButton(Color.black);
        ColorButton red = new ColorButton(Color.red);
        ColorButton blue = new ColorButton(Color.blue);
        ColorButton green = new ColorButton(Color.green);
        ColorButton magenta = new ColorButton(Color.magenta);
        ColorButton yellow = new ColorButton(Color.yellow);
        ColorButton pink = new ColorButton(Color.pink);

        white.addMouseListener(new ColorButtonMouseListener(Color.white));
        black .addMouseListener(new ColorButtonMouseListener(Color.black));
        red .addMouseListener(new ColorButtonMouseListener(Color.red));
        blue .addMouseListener(new ColorButtonMouseListener(Color.blue));
        green .addMouseListener(new ColorButtonMouseListener(Color.green));
        magenta .addMouseListener(new ColorButtonMouseListener(Color.magenta));
        yellow .addMouseListener(new ColorButtonMouseListener(Color.yellow));
        pink .addMouseListener(new ColorButtonMouseListener(Color.pink));



        panel1_4.add(white, BorderLayout.CENTER);
        panel1_4.add(black, BorderLayout.CENTER);
        panel1_4.add(red, BorderLayout.CENTER);
        panel1_4.add(blue, BorderLayout.CENTER);
        panel1_4.add(green, BorderLayout.CENTER);
        panel1_4.add(magenta, BorderLayout.CENTER);
        panel1_4.add(yellow, BorderLayout.CENTER);
        panel1_4.add(pink, BorderLayout.CENTER);


        panel1_4.setPreferredSize(new Dimension(100, 150));

//        Border border = new LineBorder(Color.black, 2);
        Border border = new LineBorder(Color.darkGray, 2);
        panel1.setBorder(border);


        //Figure Buttons

        Icon rect = new ImageIcon("rectangle.png");
        Icon circle = new ImageIcon("circle.png");
        Icon triangle = new ImageIcon("triangle.png");
        Icon line = new ImageIcon("line.png");


        JButton brect = new JButton("Rect");
        brect.addMouseListener(new FigureTypeMouseListener(PaintFigure.Figure.RECTANGLE));
        JButton bcircle = new JButton("Oval");
        bcircle.addMouseListener(new FigureTypeMouseListener(PaintFigure.Figure.OVAL));
        JButton btriangle = new JButton(triangle);
        JButton bline = new JButton(line);


        brect.setPreferredSize(new Dimension(120, 50));
        bcircle.setPreferredSize(new Dimension(120, 50));
        btriangle.setPreferredSize(new Dimension(120, 50));
        bline.setPreferredSize(new Dimension(120, 50));


        panel1_3.add(brect);
        panel1_3.add(bcircle);
        panel1_3.add(btriangle);
        panel1_3.add(bline);

        // Tool Button

        Icon pencil = new ImageIcon("pencil.png");
        Icon fill = new ImageIcon("fill.png");


        JButton bpencil = new JButton(pencil);
        JButton bfill = new JButton(fill);


        bpencil.setPreferredSize(new Dimension(100, 100));
        bfill.setPreferredSize(new Dimension(100, 100));


        panel1_2.add(bpencil);
        panel1_2.add(bfill);


//
//        panel1_2.add(menubar,NORTH);
//        menubar.setPreferredSize(new Dimension(50,20));

//        panel1.add(l1);





        panel1.setPreferredSize(new Dimension(1500, 120));

        DrawingPanel panel2 = new DrawingPanel();

        frame.getContentPane().add(panel1, NORTH);
        frame.getContentPane().add(panel2);
        frame.setLocation(100, 100);
        frame.setSize(1000, 600);
        getContentPane().setBackground(Color.WHITE);

        frame.setVisible(true);

    }


}

