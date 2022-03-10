package com.NumCo.numberconverter.CipherCreation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.Log;

import com.NumCo.numberconverter.Database.Settings;
import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.NumCo.numberconverter.ObjectPainter.Painter;

import java.util.Objects;

public class CipherImageCreator {
    private String decimal;
    private Settings settings;
    private CipherObjectBitmaps cipherObjectBitmaps;
    private Painter painter;

    public CipherImageCreator(String decimal, CipherObjectBitmaps cipherObjectBitmaps, Context context) {
        this.decimal = decimal;
        this.settings = new Settings(context);
        this.cipherObjectBitmaps = cipherObjectBitmaps;
    }

    public Bitmap generate() {
        float resolution = settings.getShapeResolution();
        int columns = settings.getImageColumns(), count = 0;
        int rows = (int) Math.ceil((double) decimal.length() / columns);


        Bitmap[] bitmaps = new Bitmap[decimal.length()];

        for(char character: decimal.toCharArray()){
            painter = new Painter(500, 500);
            ColorFilter colorFilter = new PorterDuffColorFilter(
                    settings.getCipherColor("ID" + character),
                    PorterDuff.Mode.SRC_IN);
            bitmaps[count] = painter
                    .drawBitmap(0, 0,
                            Objects.requireNonNull(cipherObjectBitmaps.objects
                                    .get("ID" + character))
                                    .getBitmap(),
                            colorFilter)
                    .scale(resolution, resolution)
                    .getBitmap();
            count++;
        }

        painter = new Painter((500 * resolution) * columns,
                (500 * resolution) * (int) Math.ceil((double) decimal.length() / columns));
        count = 0;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < columns; col++){

                if(count >= bitmaps.length)
                    break;

                painter.drawBitmap((float) painter.width / columns * col,
                        (float) painter.height / rows * row,
                        bitmaps[count], null);
                count++;
            }
        }

        Log.e("Count:", count + ", " + bitmaps.length);

        return painter.getBitmap();
    }

}
