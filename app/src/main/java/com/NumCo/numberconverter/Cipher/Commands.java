package com.NumCo.numberconverter.Cipher;

import android.graphics.Bitmap;

import com.NumCo.numberconverter.ObjectPainter.Painter;

public class Commands {

    public static String[] helpImageIds = {"DEC", "ROM", "HEX", "OCT", "BIN", "CIPHER"};
    public static String[] cipherImageIds = {"ID0", "ID1", "ID2", "ID3", "ID4", "ID5", "ID6", "ID7", "ID8", "ID9"};

    public static String[] getID0(int color) {
        return new String[]{
                "dA" + "|" + "80" + "|" + "80" + "|" + "420" + "|" + "420" + "|" + "30" + "|" + "120" + "|" + "false" + "|" + color,
                "dL" + "|" + "85" + "|" + "250" + "|" + "415" + "|" + "250" + "|" + "15" + "|" + color,
                "dBA" + "|" + "80" + "|" + "80" + "|" + "420" + "|" + "420" + "|" + "30" + "|" + "-240" + "|" + "false" + "|" + "15" + "|" + color,
                "dBC" + "|" + "65" + "|" + "15" + "|" + color,
                "dBC" + "|" + "30" + "|" + "10" + "|" + color
        };
    }

    public static String[] getID1(int color) {
        return new String[]{
                "dBC" + "|" + "200" + "|" + "10" + "|" + color,
                "dBC" + "|" + "100" + "|" + "5" + "|" + color
        };
    }

    public static String[] getID2(int color) {
        return new String[]{
                "dBC" + "|" + "200" + "|" + "10" + "|" + color,
                "dBR" + "|" + "100f" + "|" + "150f" + "|" + "400f" + "|" + "350f" + "|" + "5" + "|" + color
        };
    }

    public static String[] getID3(int color) {
        return new String[]{
                "dBR" + "|" + "100f" + "|" + "150f" + "|" + "400f" + "|" + "350f" + "|" + "5" + "|" + color,
                "dBA" + "|" + "100f" + "|" + "150f" + "|" + "400f" + "|" + "350f" + "|" + "0" + "|" + "180" + "|" + "false" + "|" + "5" + "|" + color,
                "dBA" + "|" + "100" + "|" + "150" + "|" + "400" + "|" + "350" + "|" + "180" + "|" + "360" + "|" + "false" + "|" + "5" + "|" + color
        };
    }

    public static String[] getID4(int color) {
        return new String[]{
                "dBA" + "|" + "100f" + "|" + "150f" + "|" + "400f" + "|" + "350f" + "|" + "0" + "|" + "180" + "|" + "false" + "|" + "5" + "|" + color,
                "dBA" + "|" + "100" + "|" + "150" + "|" + "400" + "|" + "350" + "|" + "180" + "|" + "360" + "|" + "false" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "150" + "|" + "250" + "|" + "350" + "|" + "5" + "|" + color,
                "dBR" + "|" + "100f" + "|" + "150f" + "|" + "400f" + "|" + "350f" + "|" + "5" + "|" + color

        };
    }

    public static String[] getID5(int color) {
        return new String[]{
                "dL" + "|" + "99f" + "|" + "147f" + "|" + "417f" + "|" + "366f" + "|" + "7" + "|" + color,
                "dL" + "|" + "91f" + "|" + "374f" + "|" + "415f" + "|" + "155f" + "|" + "7" + "|" + color,
                "dBA" + "|" + "91f" + "|" + "345f" + "|" + "420f" + "|" + "395f" + "|" + "207" + "|" + "324" + "|" + "false" + "|" + "5" + "|" + color,
                "dBA" + "|" + "100f" + "|" + "125f" + "|" + "420f" + "|" + "175f" + "|" + "185" + "|" + "324" + "|" + "false" + "|" + "5" + "|" + color
        };
    }

    public static String[] getID6(int color) {
        return new String[]{
                "dBA" + "|" + "100f" + "|" + "150f" + "|" + "400f" + "|" + "350f" + "|" + "0" + "|" + "180" + "|" + "false" + "|" + "5" + "|" + color,
                "dBA" + "|" + "100" + "|" + "150" + "|" + "400" + "|" + "350" + "|" + "180" + "|" + "360" + "|" + "false" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "150" + "|" + "100" + "|" + "260" + "|" + "5" + "|" + color,
                "dL" + "|" + "100" + "|" + "260" + "|" + "250" + "|" + "350" + "|" + "5" + "|" + color,
                "dL" + "|" + "400" + "|" + "260" + "|" + "250" + "|" + "350" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "150" + "|" + "400" + "|" + "260" + "|" + "5" + "|" + color
        };
    }

    public static String[] getID7(int color) {
        return new String[]{
                "dL" + "|" + "100" + "|" + "260" + "|" + "250" + "|" + "445" + "|" + "5" + "|" + color,
                "dL" + "|" + "400" + "|" + "260" + "|" + "250" + "|" + "445" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "55" + "|" + "400" + "|" + "260" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "55" + "|" + "100" + "|" + "260" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "150" + "|" + "100" + "|" + "260" + "|" + "5" + "|" + color,
                "dL" + "|" + "100" + "|" + "260" + "|" + "250" + "|" + "350" + "|" + "5" + "|" + color,
                "dL" + "|" + "400" + "|" + "260" + "|" + "250" + "|" + "350" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "150" + "|" + "400" + "|" + "260" + "|" + "5" + "|" + color
        };
    }

    public static String[] getID8(int color) {
        return new String[]{
                "dBA" + "|" + "100f" + "|" + "150f" + "|" + "400f" + "|" + "350f" + "|" + "0" + "|" + "180" + "|" + "false" + "|" + "5" + "|" + color,
                "dBA" + "|" + "100" + "|" + "150" + "|" + "400" + "|" + "350" + "|" + "180" + "|" + "360" + "|" + "false" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "150" + "|" + "100" + "|" + "260" + "|" + "5" + "|" + color,
                "dL" + "|" + "100" + "|" + "260" + "|" + "250" + "|" + "350" + "|" + "5" + "|" + color,
                "dL" + "|" + "400" + "|" + "260" + "|" + "250" + "|" + "350" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "150" + "|" + "400" + "|" + "260" + "|" + "5" + "|" + color,
                "dBR" + "|" + "100f" + "|" + "150f" + "|" + "400f" + "|" + "350f" + "|" + "5" + "|" + color
        };
    }

    public static String[] getID9(int color) {
        return new String[]{
                "dBC" + "|" + "200" + "|" + "10" + "|" + color,
                "dL" + "|" + "250" + "|" + "150" + "|" + "100" + "|" + "260" + "|" + "5" + "|" + color,
                "dL" + "|" + "100" + "|" + "260" + "|" + "250" + "|" + "350" + "|" + "5" + "|" + color,
                "dL" + "|" + "400" + "|" + "260" + "|" + "250" + "|" + "350" + "|" + "5" + "|" + color,
                "dL" + "|" + "250" + "|" + "150" + "|" + "400" + "|" + "260" + "|" + "5" + "|" + color
        };
    }

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

    public static String[] getCipherImageCommands(String name, int color) {
        switch (name) {
            case "ID0":
                return getID0(color);
            case "ID1":
                return getID1(color);
            case "ID2":
                return getID2(color);
            case "ID3":
                return getID3(color);
            case "ID4":
                return getID4(color);
            case "ID5":
                return getID5(color);
            case "ID6":
                return getID6(color);
            case "ID7":
                return getID7(color);
            case "ID8":
                return getID8(color);
            case "ID9":
                return getID9(color);
            default:
                return new String[0];
        }
    }
}
