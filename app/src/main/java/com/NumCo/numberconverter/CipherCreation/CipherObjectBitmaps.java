package com.NumCo.numberconverter.CipherCreation;

import com.NumCo.numberconverter.ObjectPainter.BitmapObject;
import com.NumCo.numberconverter.ObjectPainter.Painter;

import java.util.ArrayList;

public class CipherObjectBitmaps {
    public ArrayList<BitmapObject> objects;
    public short columns = 0;

    public CipherObjectBitmaps(short columns) {
        this.columns = columns;
        addObjects();
    }

    public BitmapObject getBitmapById(String id) {
        int objectIndex = 0;
        while (!objects.get(objectIndex).getId().equals(id))
            objectIndex++;

        return objects.get(objectIndex);
    }

    private void addObjects() {

    }
}
