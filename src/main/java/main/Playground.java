package main;

import paint.Paint;

import javax.swing.*;
import java.awt.*;

/**
 * Created by s.huseynli on 1/27/2020.
 */
public class Playground {
    public static void main(String[] args) {


//        JFrame.setDefaultLookAndFeelDecorated(true);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
//                Paint paint = new Paint();
                MainClass paint = new MainClass();
            }
        });
    }
}
