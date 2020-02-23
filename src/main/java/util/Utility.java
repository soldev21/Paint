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
}
