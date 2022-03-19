package com.NumCo.numberconverter.Cipher;

import android.content.Context;
import android.graphics.Bitmap;

import com.NumCo.numberconverter.Database.Settings;
import com.NumCo.numberconverter.ObjectPainter.Generator;
import com.NumCo.numberconverter.ObjectPainter.Painter;
import com.NumCo.numberconverter.ObjectPainter.Status;

public class ImageCreator {
    private String numeral;
    private Settings settings;
    private Painter painter;

    public ImageCreator(String numeral, Context context) {
        this.numeral = numeral;
        this.settings = new Settings(context);
    }

    public Bitmap generate() {
        float resolution = settings.getShapeResolution();
        int columns = settings.getImageColumns(), count = 0;
        int rows = (int) Math.ceil((double) numeral.length() / columns);


        Bitmap[] bitmaps = new Bitmap[numeral.length()];

        for (char character : numeral.toCharArray()) {
            painter = new Painter(500, 500);
            bitmaps[count] = painter
                    .drawBitmap(0, 0, Generator.generate(Commands.getCipherImageCommands(
                            "ID" + character, Status.NORMAL.color)), null)
                    .scale(resolution, resolution)
                    .getBitmap();
            count++;
        }

        painter = new Painter((500 * resolution) * columns,
                (500 * resolution) * (int) Math.ceil((double) numeral.length() / columns));
        count = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {

                if (count >= bitmaps.length)
                    break;

                painter.drawBitmap((float) painter.width / columns * col,
                        (float) painter.height / rows * row,
                        bitmaps[count], null);
                count++;
            }
        }
        painter.setBackground(settings.getBackgroundColor());

        return painter.getBitmap();
    }

}
