package com.NumCo.numberconverter.ObjectPainter;

import android.graphics.Bitmap;

public class BitmapObject {
    private String id;
    private Bitmap bitmap;
    private String description;

    public BitmapObject(String id, Bitmap bitmap) {
        this.id = id;
        this.bitmap = bitmap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
