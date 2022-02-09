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
    public ArrayList<BitmapObject> objects = new ArrayList<>();
    public HashMap<String, BitmapObject> constantObjects = new HashMap<>();
    public short columns = 0;

    public CipherObjectBitmaps(Integer color) {
        addConstantObjects(color);
    }

    public CipherObjectBitmaps(Short columns) {
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
     * <code>
     * objects.add(new BitmapObject("Something",
     *                 new Painter(500, 500, Bitmap.Config.ARGB_8888)
     *                 .drawBorderedRoundedRectangle(20 * 3, 20 * 3, 180 * 3, 180 * 3, 10 * 3, 10 * 3, 5 * 3, Color.BLUE)
     *                 .drawArc(40 * 3, 40 * 3, 160 * 3, 160 * 3, 30, 120, true, Color.GREEN)
     *                 .drawBorderedArc(40 * 3, 40 * 3, 160 * 3, 160 * 3, -30, -120, false, 5 * 3, Color.GREEN)
     *                 .drawBorderedCircle(100 * 3, 100 * 3, 25 * 3, 5 * 3, Color.MAGENTA)
     *                 .getBitmap()
     *         , ObjectBitmapStatus.NORMAL));
     * </code>
     */

    private void addObjects() {
        objects.add(new BitmapObject("ID1", new Painter(500, 500, Bitmap.Config.ARGB_8888)
                .drawBorderedCircle(200, 10, Color.RED)
                .drawBorderedCircle(100, 5, Color.GREEN)
                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.add(new BitmapObject("ID2", new Painter(500, 500, Bitmap.Config.ARGB_8888)
                .drawBorderedCircle(200, 10, Color.RED)
                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)
                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.add(new BitmapObject("ID3", new Painter(500, 500, Bitmap.Config.ARGB_8888)
                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)
                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)
                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.add(new BitmapObject("ID4", new Painter(500, 500, Bitmap.Config.ARGB_8888)
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)
                .drawLine(250, 150, 250, 350, 5, Color.BLUE)
                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)
                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.add(new BitmapObject("ID5", new Painter(500,500,Bitmap.Config.ARGB_8888)
                .drawBorderedCircle(200, 10, Color.RED)
                .drawLine(100,260,250,445,5,Color.CYAN)//left-bottom
                .drawLine(400,260,250,445,5,Color.CYAN)//right-bottom
                .drawLine(250,55,400,260,5,Color.CYAN)//right-top
                .drawLine(250,55,100,260,5,Color.CYAN)//left-top
                .getBitmap(), ObjectBitmapStatus.NORMAL ));



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
                .getBitmap(),ObjectBitmapStatus.DISABLED));

        constantObjects.put("OCT", new BitmapObject("OCT", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("OCT", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("BIN", new BitmapObject("BIN", new Painter(200, 150, Bitmap.Config.ARGB_8888)
                .drawRoundedBorderAroundBitmap(30, 10, color)
                .drawTextAtCenter("BIN", Typeface.create(Typeface.SERIF, Typeface.BOLD), 65, color)
                .getBitmap(), ObjectBitmapStatus.DISABLED));
    }
}
