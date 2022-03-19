package com.NumCo.numberconverter.ObjectPainter;

import android.graphics.Bitmap;

@Deprecated
public class ImageData {

    private String id;
    private Bitmap bitmap;
    private String description;
    private Status status;

    public ImageData(String id, Bitmap bitmap, Status status) {
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

    public Status getBitmapStatus() {
        return status;
    }

    public void setBitmapStatus(Status status) {
        this.status = status;
    }
}
