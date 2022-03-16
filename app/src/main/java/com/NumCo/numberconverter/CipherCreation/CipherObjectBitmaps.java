package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.NumCo.numberconverter.ObjectPainter.ObjectBitmapStatus;
import com.NumCo.numberconverter.ObjectPainter.Painter;

import java.util.HashMap;
import java.util.Map;

public class CipherObjectBitmaps implements Parcelable {
    public HashMap<String, BitmapObject> objects = new HashMap<>();
    // public HashMap<String, String[]> newObjects = new HashMap<>();
    public String[] keyArray = {"ID0", "ID1", "ID2", "ID3", "ID4", "ID5", "ID6", "ID7", "ID8", "ID9"};

    public CipherObjectBitmaps() {
        addObjects();
    }

    public CipherObjectBitmaps(Parcel source) {
        int size = source.readInt();
        while (size > 0) {
            objects.put(source.readString(),
                    (BitmapObject) source.readParcelable(BitmapObject.class.getClassLoader()));
            size--;
        }
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

    /*
    private void addNewObjects() {
        newObjects.put(keyArray[0], new String[] {
                "dA|80|80|420|420|30|120|true|" + Color.GREEN,
                "dL|X_1|Y_1|X_2|Y_2|thickness|color"
        });
    }
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

        objects.put("ID1", new BitmapObject("ID1", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedCircle(200, 10, Color.RED)

                .drawBorderedCircle(100, 5, Color.GREEN)

                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.put("ID2", new BitmapObject("ID2", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedCircle(200, 10, Color.RED)

                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)

                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.put("ID3", new BitmapObject("ID3", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)

                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)

                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.put("ID4", new BitmapObject("ID4", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)

                .drawLine(250, 150, 250, 350, 5, Color.BLUE)

                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)

                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.put("ID5", new BitmapObject("ID5", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedCircle(200, 10, Color.RED)

                .drawLine(100, 260, 250, 445, 5, Color.CYAN)//left-bottom
                .drawLine(400, 260, 250, 445, 5, Color.CYAN)//right-bottom
                .drawLine(250, 55, 400, 260, 5, Color.CYAN)//right-top
                .drawLine(250, 55, 100, 260, 5, Color.CYAN)//left-top

                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.put("ID6", new BitmapObject("ID6", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)//lower-arc-of-ellipse
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)//upper-arc-of-ellipse

                .drawLine(250, 150, 100, 260, 5, Color.DKGRAY)//left-top
                .drawLine(100, 260, 250, 350, 5, Color.DKGRAY)//left-bottom
                .drawLine(400, 260, 250, 350, 5, Color.DKGRAY)//right-bottom
                .drawLine(250, 150, 400, 260, 5, Color.DKGRAY)//right-top

                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.put("ID7", new BitmapObject("ID7", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawLine(100, 260, 250, 445, 5, Color.CYAN)//left-bottom
                .drawLine(400, 260, 250, 445, 5, Color.CYAN)//right-bottom
                .drawLine(250, 55, 400, 260, 5, Color.CYAN)//right-top
                .drawLine(250, 55, 100, 260, 5, Color.CYAN)//left-top

                .drawLine(250, 150, 100, 260, 5, Color.DKGRAY)//left-top
                .drawLine(100, 260, 250, 350, 5, Color.DKGRAY)//left-bottom
                .drawLine(400, 260, 250, 350, 5, Color.DKGRAY)//right-bottom
                .drawLine(250, 150, 400, 260, 5, Color.DKGRAY)//right-top

                .getBitmap(), ObjectBitmapStatus.NORMAL));
        objects.put("ID8", new BitmapObject("ID8", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)

                .drawLine(250, 150, 100, 260, 5, Color.DKGRAY)//left-top
                .drawLine(100, 260, 250, 350, 5, Color.DKGRAY)//left-bottom
                .drawLine(400, 260, 250, 350, 5, Color.DKGRAY)//right-bottom
                .drawLine(250, 150, 400, 260, 5, Color.DKGRAY)//right-top

                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)

                .getBitmap(), ObjectBitmapStatus.NORMAL));

        objects.put("ID9", new BitmapObject("ID9", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedCircle(200, 10, Color.RED)

                .drawLine(250, 150, 100, 260, 5, Color.DKGRAY)//left-top
                .drawLine(100, 260, 250, 350, 5, Color.DKGRAY)//left-bottom
                .drawLine(400, 260, 250, 350, 5, Color.DKGRAY)//right-bottom
                .drawLine(250, 150, 400, 260, 5, Color.DKGRAY)//right-top

                .getBitmap(), ObjectBitmapStatus.NORMAL));
    }

    public static final Creator<CipherObjectBitmaps> CREATOR = new Creator<CipherObjectBitmaps>() {
        @Override
        public CipherObjectBitmaps createFromParcel(Parcel in) {
            return new CipherObjectBitmaps(in);
        }

        @Override
        public CipherObjectBitmaps[] newArray(int size) {
            return new CipherObjectBitmaps[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(objects.size());
        for (Map.Entry<String, BitmapObject> entries : objects.entrySet()) {
            dest.writeString(entries.getKey());
            dest.writeParcelable(entries.getValue(), flags);
        }
    }
}
