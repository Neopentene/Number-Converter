package com.NumCo.numberconverter.CipherCreation;

import android.graphics.Bitmap;

import com.NumCo.numberconverter.ObjectPainter.Painter;

public class Commands {

    public static String[] helpImageIds = {"DEC", "ROM", "HEX", "OCT", "BIN", "CIPHER"};
    public static String[] cipherImageIds = {"ID0", "ID1", "ID2", "ID3", "ID4", "ID5", "ID6", "ID7", "ID8", "ID9"};

    public static String[] getDEC(int color) {
        return new String[]{
                "sB" + "|" + 200 + "|" + 150 + "|" + Bitmap.Config.ARGB_8888.name(),
                "dRBAB" + "|" + 30 + "|" + 10 + "|" + color,
                "dTC" + "|" + "DEC" + "|" + "SERIF" + "_" + Painter.FONT_BOLD + "|" + 65 + "|" + color
        };
    }

    public static String[] getROM(int color) {
        return new String[]{
                "sB" + "|" + 200 + "|" + 150 + "|" + Bitmap.Config.ARGB_8888.name(),
                "dRBAB" + "|" + 30 + "|" + 10 + "|" + color,
                "dTC" + "|" + "ROM" + "|" + "SERIF" + "_" + Painter.FONT_BOLD + "|" + 65 + "|" + color
        };
    }

    public static String[] getHEX(int color) {
        return new String[]{
                "sB" + "|" + 200 + "|" + 150 + "|" + Bitmap.Config.ARGB_8888.name(),
                "dRBAB" + "|" + 30 + "|" + 10 + "|" + color,
                "dTC" + "|" + "HEX" + "|" + "SERIF" + "_" + Painter.FONT_BOLD + "|" + 65 + "|" + color
        };
    }

    public static String[] getOCT(int color) {
        return new String[]{
                "sB" + "|" + 200 + "|" + 150 + "|" + Bitmap.Config.ARGB_8888.name(),
                "dRBAB" + "|" + 30 + "|" + 10 + "|" + color,
                "dTC" + "|" + "OCT" + "|" + "SERIF" + "_" + Painter.FONT_BOLD + "|" + 65 + "|" + color
        };
    }

    public static String[] getBIN(int color) {
        return new String[]{
                "sB" + "|" + 200 + "|" + 150 + "|" + Bitmap.Config.ARGB_8888.name(),
                "dRBAB" + "|" + 30 + "|" + 10 + "|" + color,
                "dTC" + "|" + "BIN" + "|" + "SERIF" + "_" + Painter.FONT_BOLD + "|" + 65 + "|" + color
        };
    }

    public static String[] getCIPHER(int color) {
        return new String[]{
                "sB" + "|" + 325 + "|" + 150 + "|" + Bitmap.Config.ARGB_8888.name(),
                "dRBAB" + "|" + 30 + "|" + 10 + "|" + color,
                "dTC" + "|" + "CIPHER" + "|" + "SERIF" + "_" + Painter.FONT_BOLD + "|" + 65 + "|" + color
        };
    }

    public static String[] getPlaceholder(int color) {
        return new String[]{
                "sB" + "|" + 500 + "|" + 150 + "|" + Bitmap.Config.ARGB_8888.name(),
                "dRBAB" + "|" + 30 + "|" + 10 + "|" + color,
                "dTC" + "|" + "Coming Soon" + "|" + "SERIF" + "_" + Painter.FONT_BOLD + "|" + 65 + "|" + color
        };
    }

    public static String[] getHelpImageCommands(String name, int color) {
        switch (name.toLowerCase()) {
            case "dec":
                return getDEC(color);
            case "rom":
                return getROM(color);
            case "hex":
                return getHEX(color);
            case "oct":
                return getOCT(color);
            case "bin":
                return getBIN(color);
            case "cipher":
                return getCIPHER(color);
            default:
                return new String[0];
        }
    }
}
