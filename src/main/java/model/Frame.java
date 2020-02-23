package model;

import az.egov.asanpay.commons.util.TimerUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by s.huseynli on 1/27/2020.
 */
public class Frame extends java.awt.Frame implements KeyListener{
    BufferedImage img;
    Image cursor = ImageIO.read(new File("D://cursor.png"));
    Robot robot = new Robot();
    MediaTracker mt;
    Dimension dimension;
    Frame frame;
    Graphics graphics;
    int x,y;
    boolean showCursor = false;
    TimerUtil timerUtil = TimerUtil.newInstance();
    static GraphicsDevice device = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices()[0];
    ExecutorService service = Executors.newFixedThreadPool(10);
//    Queue<BufferedImage> imageQueue = new ConcurrentLinkedDeque<>();

    public Frame() throws AWTException, IOException, InterruptedException {
        frame = this;
        addKeyListener(frame);

//        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        dimension = new Dimension(500,500);
        addButton();




        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dispose();
//                setExtendedState(Frame.MAXIMIZED_BOTH);
//                setUndecorated(true);

            }


        });

        //setUndecorated(true);
        setSize(dimension);//frame size 300 width and 300 height
        setLayout(null);//no layout manager
        setVisible(true);//now frame will be visible, by default not visible
        graphics = getGraphics();
        new Thread(()->{
            while (true) {
                service.execute(()->{
                    setImg();
                });
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            while (true) {
                    update(graphics);
            }
        }).start();

        new Thread(()->{
            while (true) {
                updateCursor();
            }
        }).start();
    }

    private void addButton(){
        Button b=new Button("click me");
        b.setBounds(30,100,80,30);// setting button position
        add(b);//adding button into frame
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                device.setFullScreenWindow(frame);
                System.out.println("Button Action performed");
                //device.setFullScreenWindow(frame);
                showCursor = !showCursor;
            }
        });
    }

    private void validate1(){
        super.validate();
    }

    private void setImg(){
//        timerUtil.point();
        BufferedImage image = robot.createScreenCapture(new Rectangle(0,0,dimension.width,dimension.height));
//        imageQueue.add(robot.createScreenCapture(new Rectangle(0,0,dimension.width,dimension.height)));
//        timerUtil.printPoint();
//        System.out.println(imageQueue.size());
          if (showCursor)  image.getGraphics().drawImage(cursor, x, y, 16, 23, null); // cursor.gif is 16x16 size.
        img = image;
//        timerUtil.printPoint();
        System.out.println("****************");
//        img = Toolkit.getDefaultToolkit().getImage("E://a.png");

    }


    public void updateCursor(){
        x = MouseInfo.getPointerInfo().getLocation().x;
        y = MouseInfo.getPointerInfo().getLocation().y;
    }


    public void update(Graphics g){
        paint(g);
    }

    public void paint(Graphics g){
//        g.drawImage(img, 300, 300, this);

            if (img != null){
                    g.drawImage(img, 0, 0, this);
            }
            else
//                g.drawImage(img, 0, 0, this);
                g.clearRect(0, 0, getSize().width, getSize().height);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e);
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
