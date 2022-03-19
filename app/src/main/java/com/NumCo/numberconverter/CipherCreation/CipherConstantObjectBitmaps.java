package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;

import com.NumCo.numberconverter.ObjectPainter.ImageData;
import com.NumCo.numberconverter.ObjectPainter.ObjectBitmapStatus;
import com.NumCo.numberconverter.ObjectPainter.Painter;
import com.NumCo.numberconverter.ObjectPainter.Status;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class CipherConstantObjectBitmaps {
    public HashMap<String, ImageData> constantObjects = new HashMap<>();

    public CipherConstantObjectBitmaps() {
        addConstantObjects();
    }

    private void addConstantObjects() {
        constantObjects.put("DEC", new ImageData("DEC",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("DEC", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), Status.DISABLED));

        constantObjects.put("ROM", new ImageData("ROM",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("ROM", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), Status.DISABLED));

        constantObjects.put("HEX", new ImageData("HEX",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("HEX", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), Status.DISABLED));

        constantObjects.put("OCT", new ImageData("OCT",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("OCT", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), Status.DISABLED));

        constantObjects.put("BIN", new ImageData("BIN",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("BIN", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), Status.DISABLED));

        constantObjects.put("CIPHER", new ImageData("CIPHER",
                new Painter(325, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("CIPHER", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), Status.NORMAL));
    }
}
