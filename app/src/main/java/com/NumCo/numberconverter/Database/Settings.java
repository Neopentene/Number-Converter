package com.NumCo.numberconverter.Database;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {
    private final SharedPreferences cipherNumbers;
    private final SharedPreferences cipherColors;
    private final SharedPreferences otherSettings;
    private final SharedPreferences.Editor editorCipherNumbers;
    private final SharedPreferences.Editor editorCipherColors;
    private final SharedPreferences.Editor editorOtherSettings;


    public Settings(Context context) {
        cipherColors = context.getSharedPreferences("cipher_id_numbers", Context.MODE_PRIVATE);
        cipherNumbers = context.getSharedPreferences("cipher_id_colors", Context.MODE_PRIVATE);
        otherSettings = context.getSharedPreferences("otherSettings", Context.MODE_PRIVATE);
        editorCipherColors = cipherColors.edit();
        editorCipherNumbers = cipherNumbers.edit();
        editorOtherSettings = otherSettings.edit();
    }

    public int getCipherNumberFromId(String id) {
        return cipherNumbers.getInt(id, Integer.parseInt(String.valueOf(id.charAt(id.length() - 1))));
    }

    public void setCipherNumberFromId(String id, int number) {
        editorCipherNumbers.putInt(id, number).apply();
    }

    public int getCipherColors(String id) {
        return cipherColors.getInt(id, Integer.parseInt(String.valueOf(id.charAt(id.length() - 1))));
    }

    public void setCipherColors(String id, int color) {
        editorCipherColors.putInt(id, color).apply();
    }

    public int getOtherSettings(String id) {
        if (id.equals("RES"))
            return otherSettings.getInt(id, 500);
        if (id.equals("COL"))
            return otherSettings.getInt(id, 5);
        return otherSettings.getInt(id, 0);

    }
}
