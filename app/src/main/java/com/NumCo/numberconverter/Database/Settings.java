package com.NumCo.numberconverter.Database;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {
    private final SharedPreferences cipherNumbers;
    private SharedPreferences cipherColors;
    private SharedPreferences.Editor editorCipherNumbers;
    private SharedPreferences.Editor editorCipherColors;

    public Settings(Context context) {
        cipherColors = context.getSharedPreferences("cipher_id_numbers", Context.MODE_PRIVATE);
        cipherNumbers = context.getSharedPreferences("cipher_id_colors", Context.MODE_PRIVATE);
        editorCipherColors = cipherColors.edit();
        editorCipherNumbers = cipherNumbers.edit();
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
}
