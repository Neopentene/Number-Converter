package com.NumCo.numberconverter.ObjectPainter;

import android.graphics.Color;

public enum Status {
    ERROR(Color.argb(255, 255, 0, 51)),
    DISABLED(Color.argb(255, 128, 128, 128)),
    NORMAL(Color.argb(255, 0, 0, 77)),
    PLACEHOLDER(Color.argb(255, 54, 143, 139)),
    INPUT(Color.argb(255, 204, 139, 0)),
    OUTPUT(Color.argb(255, 0, 167, 204)),
    NULL(Color.argb(0, 0, 0, 0));

    public final int color;

    Status(int color) {
        this.color = color;
    }
}
