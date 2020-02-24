package util;

import java.awt.*;

/**
 * Created by s.huseynli on 2/23/2020.
 */
public class Utility {




    public static final class CursorFactory{
        public static final Cursor VERTICAL_RESIZE;
        public static final Cursor HORIZONTAL_RESIZE;
        public static final Cursor DEFAULT_CURSOR;

        static {
            DEFAULT_CURSOR = new Cursor(Cursor.DEFAULT_CURSOR);
            VERTICAL_RESIZE = new Cursor(Cursor.N_RESIZE_CURSOR);
            HORIZONTAL_RESIZE = new Cursor(Cursor.E_RESIZE_CURSOR);
        }
    }

    public static class PointUtil {

        public static int distance(int x1, int y1, int x2, int y2) {
            return (int) Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));
        }

        public static int getH(int y1, int y2) {
            return y2 - y1;
        }

        public static int getW(int x1, int x2) {
            return x2 - x1;
        }
    }
}
