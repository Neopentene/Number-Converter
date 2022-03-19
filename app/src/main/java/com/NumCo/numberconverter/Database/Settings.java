package com.NumCo.numberconverter.Database;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;

import com.NumCo.numberconverter.ObjectPainter.Status;

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

    public String getCipherNumberFromId(String number) {
        return cipherNumbers.getString(number, "ID" + number);
    }

    public void setCipherNumberFromId(String id, int number) {
        editorCipherNumbers.putString(String.valueOf(number), id).apply();
    }

    public int getCipherColor(String id) {
        return cipherColors.getInt(id, Status.NORMAL.color);
    }

    public void setCipherColor(String id, int color) {
        editorCipherColors.putInt(id, color).apply();
    }

    public int getOtherSettings(String id) {
        return otherSettings.getInt(id, 2);
    }

    public int getBackgroundColor() {
        return otherSettings.getInt("background", Color.WHITE);
    }

    public int getImageColumns() {
        return otherSettings.getInt("COL", 3);
    }

    public float getShapeResolution() {
        return otherSettings.getFloat("RES", 0.7f);
    }

    public void setOtherSettings(String id, int value) {
        editorOtherSettings.putInt(id, value).apply();
    }

    public void setBackgroundColor(int color) {
        editorOtherSettings.putInt("background", color).apply();
    }

    public void setShapeResolution(float value) {
        editorOtherSettings.putFloat("RES", value).apply();
    }

    public void setImageColumns(int value) {
        editorOtherSettings.putInt("COL", value).apply();
    }
}
