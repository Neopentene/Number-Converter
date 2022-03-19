package com.NumCo.numberconverter.ObjectPainter;

import android.graphics.Color;

@Deprecated
public enum ObjectBitmapStatus {
    ERROR(Color.RED),
    NORMAL(Color.BLACK),
    DISABLED(Color.GRAY),
    ACTIVE_INPUT(Color.argb(255, 204, 139, 0)),
    ACTIVE_OUTPUT(Color.argb(255, 0, 167, 204)),
    THEME(Color.argb(255, 0, 0, 77)),
    NULL(Color.TRANSPARENT);

    public final int color;

    ObjectBitmapStatus(int color) {
        this.color = color;
    }
}
