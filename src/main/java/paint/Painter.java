package paint;

import java.awt.*;

/**
 * Created by s.huseynli on 2/24/2020.
 */
public class Painter {
//
    private static Color color = Color.RED;
    private static PaintFigure.Figure figure = PaintFigure.Figure.OVAL;
    private static PaintFigure paintFigure;

    public static PaintFigure init(int x, int y){
        return init(figure,color,x,y);
    }

    public static PaintFigure init(PaintFigure.Figure figure,Color color, int x, int y){
        paintFigure = FigureFactory.getNewFigure(figure,new Point(x,y),color);
        return paintFigure;
    }

    public static void resize(int x,int y){
        paintFigure.resizeItem(x,y);
    }

//    public static Color getColor() {
//        return color;
//    }
//
//    public static void setColor(Color color) {
//        Painter.color = color;
//    }
//
//    public static PaintFigure.Figure getFigure() {
//        return figure;
//    }
//
//    public static void setFigure(PaintFigure.Figure figure) {
//        Painter.figure = figure;
//    }


}
