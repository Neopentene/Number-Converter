package com.NumCo.numberconverter.ObjectPainter;

import android.graphics.Bitmap;

public class Generator {

    public static Bitmap generate(String[] commands) {
        Painter.Parser parser = new Painter().new Parser(commands);
        parser.parse();
        return parser.getParsedBitmap();
    }

    public static Bitmap generate(Iterable<String> commands) {
        Painter.Parser parser = new Painter().new Parser(commands);
        parser.parse();
        return parser.getParsedBitmap();
    }

}
