package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;

import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.NumCo.numberconverter.ObjectPainter.ObjectBitmapStatus;
import com.NumCo.numberconverter.ObjectPainter.Painter;

import java.util.ArrayList;
import java.util.HashMap;

public class CipherObjectBitmaps {
    public HashMap<String, BitmapObject> objects = new HashMap<>();
    public HashMap<String, BitmapObject> constantObjects = new HashMap<>();
    public String[] keyArray = {"ID0", "ID1", "ID2", "ID3", "ID4", "ID5", "ID6", "ID7", "ID8", "ID9"};

    public CipherObjectBitmaps(Integer color) {
        addConstantObjects(color);
    }

    public CipherObjectBitmaps() {
        addObjects();
    }

    /**
     * Usage example
     * <code>
     * objects.add(new BitmapObject("Something",
     * new Painter(500, 500, Bitmap.Config.ARGB_8888)
     * .drawBorderedRoundedRectangle(20 * 3, 20 * 3, 180 * 3, 180 * 3, 10 * 3, 10 * 3, 5 * 3, Color.BLUE)
     * .drawArc(40 * 3, 40 * 3, 160 * 3, 160 * 3, 30, 120, true, Color.GREEN)
     * .drawBorderedArc(40 * 3, 40 * 3, 160 * 3, 160 * 3, -30, -120, false, 5 * 3, Color.GREEN)
     * .drawBorderedCircle(100 * 3, 100 * 3, 25 * 3, 5 * 3, Color.MAGENTA)
     * .getBitmap()
     * , ObjectBitmapStatus.NORMAL));
     * </code>
     */

    private void addObjects() {
        objects.put("ID0", new BitmapObject("ID0", new Painter(500)
                .drawArc(80, 80, 420, 420, 30, 120, true, Color.GREEN)
                .drawLine(85, 250, 415, 250, 15, Color.BLACK)
                .drawBorderedArc(80, 80, 420, 420, 30, -240, false, 15, Color.GREEN)
                .drawBorderedCircle(65, 15, Color.MAGENTA)
                .drawBorderedCircle(30, 10, Color.MAGENTA)
                .getBitmap()
                , ObjectBitmapStatus.NORMAL));

        objects.put("ID1", new BitmapObject("ID1", new Painter(500)
                .drawBorderedCircle(170, 15, Color.RED)
                .drawBorderedCircle(80, 15, Color.GREEN)
                .getBitmap(), ObjectBitmapStatus.NORMAL));

        objects.put("ID2", new BitmapObject("ID2", new Painter(500)
                .drawBorderedCircle(200, 10, Color.RED)
                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)
                .getBitmap(), ObjectBitmapStatus.NORMAL));

        objects.put("ID3", new BitmapObject("ID3", new Painter(500)
                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)
                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)
                .getBitmap(), ObjectBitmapStatus.NORMAL));

        objects.put("ID4", new BitmapObject("ID4", new Painter(500)
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)
                .drawLine(250, 150, 250, 350, 5, Color.BLUE)
                .getBitmap(), ObjectBitmapStatus.NORMAL));

        objects.put("ID5", new BitmapObject("ID5", new Painter(500)
                .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.NORMAL.color)
                .drawTextAtCenter("ID5", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, ObjectBitmapStatus.NORMAL.color)
                .getBitmap(), ObjectBitmapStatus.NORMAL));

        objects.put("ID6", new BitmapObject("ID5", new Painter(500)
                .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.NORMAL.color)
                .drawTextAtCenter("ID6", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, ObjectBitmapStatus.NORMAL.color)
                .getBitmap(), ObjectBitmapStatus.NORMAL));

        objects.put("ID7", new BitmapObject("ID7", new Painter(500)
                .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.NORMAL.color)
                .drawTextAtCenter("ID7", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, ObjectBitmapStatus.NORMAL.color)
                .getBitmap(), ObjectBitmapStatus.NORMAL));

        objects.put("ID8", new BitmapObject("ID8", new Painter(500)
                .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.NORMAL.color)
                .drawTextAtCenter("ID8", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, ObjectBitmapStatus.NORMAL.color)
                .getBitmap(), ObjectBitmapStatus.NORMAL));

        objects.put("ID9", new BitmapObject("ID9", new Painter(500)
                .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.NORMAL.color)
                .drawTextAtCenter("ID9", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, ObjectBitmapStatus.NORMAL.color)
                .getBitmap(), ObjectBitmapStatus.NORMAL));
    }

    private void addConstantObjects(int color) {
        constantObjects.put("DEC", new BitmapObject("DEC", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("DEC", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("ROM", new BitmapObject("ROM", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("ROM", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("HEX", new BitmapObject("HEX", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("HEX", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("OCT", new BitmapObject("OCT", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("OCT", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("BIN", new BitmapObject("BIN", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("BIN", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("CIPHER", new BitmapObject("CIPHER", new Painter(325, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("CIPHER", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap(), ObjectBitmapStatus.THEME));
    }
}
