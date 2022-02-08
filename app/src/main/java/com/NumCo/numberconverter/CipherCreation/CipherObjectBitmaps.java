package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;

import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.NumCo.numberconverter.ObjectPainter.Painter;

import java.util.ArrayList;
import java.util.HashMap;

public class CipherObjectBitmaps {
    public ArrayList<BitmapObject> objects = new ArrayList<>();
    public HashMap<String, BitmapObject> constantObjects = new HashMap<>();
    public short columns = 0;

    public CipherObjectBitmaps(int color) {
        addConstantObjects(color);
    }

    public CipherObjectBitmaps(short columns) {
        this.columns = columns;
        addObjects();
    }

    public BitmapObject getBitmapById(String id) {
        int objectIndex = 0;
        while (!objects.get(objectIndex).getId().equals(id))
            objectIndex++;

        return objects.get(objectIndex);
    }

    /**
     * Usage example
     * objects.add(new BitmapObject("Something",
     *                 new Painter(500, 500, Bitmap.Config.ARGB_8888)
     *                 .drawBorderedRoundedRectangle(20 * 3, 20 * 3, 180 * 3, 180 * 3, 10 * 3, 10 * 3, 5 * 3, Color.BLUE)
     *                 .drawArc(40 * 3, 40 * 3, 160 * 3, 160 * 3, 30, 120, true, Color.GREEN)
     *                 .drawBorderedArc(40 * 3, 40 * 3, 160 * 3, 160 * 3, -30, -120, false, 5 * 3, Color.GREEN)
     *                 .drawBorderedCircle(100 * 3, 100 * 3, 25 * 3, 5 * 3, Color.MAGENTA)
     *                 .getBitmap()
     *         ));
     */
    
    private void addObjects() {

    }

    private void addConstantObjects(int color) {
        constantObjects.put("DEC", new BitmapObject("DEC", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("DEC", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap()));

        constantObjects.put("ROM", new BitmapObject("ROM", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("ROM", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap()));

        constantObjects.put("HEX", new BitmapObject("HEX", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("HEX", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap()));

        constantObjects.put("OCT", new BitmapObject("OCT", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("OCT", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap()));

        constantObjects.put("BIN", new BitmapObject("BIN", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("BIN", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap()));
    }
}
