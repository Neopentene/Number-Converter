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
