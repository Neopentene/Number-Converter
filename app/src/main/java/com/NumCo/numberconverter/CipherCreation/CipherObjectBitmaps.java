package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.NumCo.numberconverter.ObjectPainter.ImageData;
import com.NumCo.numberconverter.ObjectPainter.Painter;
import com.NumCo.numberconverter.ObjectPainter.Status;

import java.util.HashMap;

@Deprecated
public class CipherObjectBitmaps {
    public HashMap<String, ImageData> objects = new HashMap<>();
    // public HashMap<String, String[]> newObjects = new HashMap<>();
    public String[] keyArray = {"ID0", "ID1", "ID2", "ID3", "ID4", "ID5", "ID6", "ID7", "ID8", "ID9"};

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

    /*
    private void addNewObjects() {
        newObjects.put(keyArray[0], new String[] {
                "dA|80|80|420|420|30|120|true|" + Color.GREEN,
                "dL|X_1|Y_1|X_2|Y_2|thickness|color"
        });
    }
    */
    private void addObjects() {
        objects.put("ID0", new ImageData("ID0", new Painter(500)
                .drawArc(80, 80, 420, 420, 30, 120, true, Color.GREEN)
                .drawLine(85, 250, 415, 250, 15, Color.BLACK)
                .drawBorderedArc(80, 80, 420, 420, 30, -240, false, 15, Color.GREEN)
                .drawBorderedCircle(65, 15, Color.MAGENTA)
                .drawBorderedCircle(30, 10, Color.MAGENTA)
                .getBitmap()
                , Status.NORMAL));

        objects.put("ID1", new ImageData("ID1", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedCircle(200, 10, Color.RED)

                .drawBorderedCircle(100, 5, Color.GREEN)

                .getBitmap(), Status.NORMAL));
        objects.put("ID2", new ImageData("ID2", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedCircle(200, 10, Color.RED)

                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)

                .getBitmap(), Status.NORMAL));
        objects.put("ID3", new ImageData("ID3", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)

                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)

                .getBitmap(), Status.NORMAL));
        objects.put("ID4", new ImageData("ID4", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)

                .drawLine(250, 150, 250, 350, 5, Color.BLUE)

                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)

                .getBitmap(), Status.NORMAL));
        objects.put("ID5", new ImageData("ID5", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedCircle(200, 10, Color.RED)

                .drawLine(100, 260, 250, 445, 5, Color.CYAN)//left-bottom
                .drawLine(400, 260, 250, 445, 5, Color.CYAN)//right-bottom
                .drawLine(250, 55, 400, 260, 5, Color.CYAN)//right-top
                .drawLine(250, 55, 100, 260, 5, Color.CYAN)//left-top

                .getBitmap(), Status.NORMAL));
        objects.put("ID6", new ImageData("ID6", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)//lower-arc-of-ellipse
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)//upper-arc-of-ellipse

                .drawLine(250, 150, 100, 260, 5, Color.DKGRAY)//left-top
                .drawLine(100, 260, 250, 350, 5, Color.DKGRAY)//left-bottom
                .drawLine(400, 260, 250, 350, 5, Color.DKGRAY)//right-bottom
                .drawLine(250, 150, 400, 260, 5, Color.DKGRAY)//right-top

                .getBitmap(), Status.NORMAL));
        objects.put("ID7", new ImageData("ID7", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawLine(100, 260, 250, 445, 5, Color.CYAN)//left-bottom
                .drawLine(400, 260, 250, 445, 5, Color.CYAN)//right-bottom
                .drawLine(250, 55, 400, 260, 5, Color.CYAN)//right-top
                .drawLine(250, 55, 100, 260, 5, Color.CYAN)//left-top

                .drawLine(250, 150, 100, 260, 5, Color.DKGRAY)//left-top
                .drawLine(100, 260, 250, 350, 5, Color.DKGRAY)//left-bottom
                .drawLine(400, 260, 250, 350, 5, Color.DKGRAY)//right-bottom
                .drawLine(250, 150, 400, 260, 5, Color.DKGRAY)//right-top

                .getBitmap(), Status.NORMAL));
        objects.put("ID8", new ImageData("ID8", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedArc(100f, 150f, 400f, 350f, 0, 180, false, 5, Color.MAGENTA)
                .drawBorderedArc(100, 150, 400, 350, 180, 360, false, 5, Color.MAGENTA)

                .drawLine(250, 150, 100, 260, 5, Color.DKGRAY)//left-top
                .drawLine(100, 260, 250, 350, 5, Color.DKGRAY)//left-bottom
                .drawLine(400, 260, 250, 350, 5, Color.DKGRAY)//right-bottom
                .drawLine(250, 150, 400, 260, 5, Color.DKGRAY)//right-top

                .drawBorderedRectangle(100f, 150f, 400f, 350f, 5, Color.YELLOW)

                .getBitmap(), Status.NORMAL));

        objects.put("ID9", new ImageData("ID9", new Painter(500, 500, Bitmap.Config.ARGB_8888)

                .drawBorderedCircle(200, 10, Color.RED)

                .drawLine(250, 150, 100, 260, 5, Color.DKGRAY)//left-top
                .drawLine(100, 260, 250, 350, 5, Color.DKGRAY)//left-bottom
                .drawLine(400, 260, 250, 350, 5, Color.DKGRAY)//right-bottom
                .drawLine(250, 150, 400, 260, 5, Color.DKGRAY)//right-top

                .getBitmap(), Status.NORMAL));
    }
}
