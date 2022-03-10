package com.NumCo.numberconverter.ObjectPainter;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class BitmapObject implements Parcelable {

    private String id;
    private Bitmap bitmap;
    private String description;
    private ObjectBitmapStatus status;

    protected BitmapObject(Parcel in) {
        id = in.readString();
        bitmap = in.readParcelable(Bitmap.class.getClassLoader());
        description = in.readString();
        status = ObjectBitmapStatus.values()[in.readInt()];
    }

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

    public static final Creator<BitmapObject> CREATOR = new Creator<BitmapObject>() {
        @Override
        public BitmapObject createFromParcel(Parcel in) {
            return new BitmapObject(in);
        }

        @Override
        public BitmapObject[] newArray(int size) {
            return new BitmapObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeParcelable(bitmap, flags);
        dest.writeString(description);
        dest.writeInt(status.ordinal());
    }
}
