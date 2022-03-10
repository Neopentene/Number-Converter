package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Parcel;
import android.os.Parcelable;

import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.NumCo.numberconverter.ObjectPainter.ObjectBitmapStatus;
import com.NumCo.numberconverter.ObjectPainter.Painter;

import java.util.HashMap;
import java.util.Map;

public class CipherConstantObjectBitmaps implements Parcelable {
    public HashMap<String, BitmapObject> constantObjects = new HashMap<>();

    public CipherConstantObjectBitmaps() {
        addConstantObjects();
    }

    protected CipherConstantObjectBitmaps(Parcel in) {
        int size = in.readInt();
        while(size > 0){
            constantObjects.put(in.readString(),
                    (BitmapObject) in.readParcelable(BitmapObject.class.getClassLoader()));
            size--;
        }
    }

    private void addConstantObjects() {
        constantObjects.put("DEC", new BitmapObject("DEC",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("DEC", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("ROM", new BitmapObject("ROM",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("ROM", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("HEX", new BitmapObject("HEX",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("HEX", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("OCT", new BitmapObject("OCT",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("OCT", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("BIN", new BitmapObject("BIN",
                new Painter(200, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("BIN", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), ObjectBitmapStatus.DISABLED));

        constantObjects.put("CIPHER", new BitmapObject("CIPHER",
                new Painter(325, 150, Bitmap.Config.ARGB_8888)
                        .drawRoundedBorderAroundBitmap(30, 10, ObjectBitmapStatus.DISABLED.color)
                        .drawTextAtCenter("CIPHER", Typeface.create(Typeface.SERIF, Typeface.BOLD),
                                65, ObjectBitmapStatus.DISABLED.color)
                        .getBitmap(), ObjectBitmapStatus.THEME));
    }

    public static final Creator<CipherConstantObjectBitmaps> CREATOR = new Creator<CipherConstantObjectBitmaps>() {
        @Override
        public CipherConstantObjectBitmaps createFromParcel(Parcel in) {
            return new CipherConstantObjectBitmaps(in);
        }

        @Override
        public CipherConstantObjectBitmaps[] newArray(int size) {
            return new CipherConstantObjectBitmaps[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(constantObjects.size());
        for (Map.Entry<String, BitmapObject> entries : constantObjects.entrySet()) {
            dest.writeString(entries.getKey());
            dest.writeParcelable(entries.getValue(), flags);
        }
    }
}
