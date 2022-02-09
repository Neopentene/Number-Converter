package com.NumCo.numberconverter.ObjectPainter;

import android.graphics.Bitmap;

public class BitmapObject {

    private String id;
    private Bitmap bitmap;
    private String description;
    private ObjectBitmapStatus status;

    public BitmapObject(String id, Bitmap bitmap, ObjectBitmapStatus status) {
        this.id = id;
        this.bitmap = bitmap;
        this.status = status;
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

    public ObjectBitmapStatus getBitmapStatus() {
        return status;
    }

    public void setBitmapStatus(ObjectBitmapStatus status) {
        this.status = status;
    }
}
