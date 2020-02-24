package paint;

import java.awt.*;

/**
 * Created by s.huseynli on 2/24/2020.
 */
public final class FigureFactory {

    private FigureFactory(){};

    public static PaintFigure getNewFigure(PaintFigure.Figure figure, Point startPoint, Color color){
        switch (figure){
            case OVAL: return new Oval(startPoint,color);
            case RECTANCGLE: return new Rectangle(startPoint,color);
        }
        throw new RuntimeException("There is no any "+figure+" implementation");
    }
}
