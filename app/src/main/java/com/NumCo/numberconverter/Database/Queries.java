package com.NumCo.numberconverter.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.NumCo.numberconverter.Database.*;
import com.NumCo.numberconverter.Objects.HISTORY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Queries {

    private Schemas.History history;
    private Schemas schemas;
    private SQLiteDatabase db;

    public void addHistory(HISTORY historyObject, Context context) {
        schemas = new Schemas(context);
        history = new Schemas.History();

        db = schemas.getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put(history.INPUT_TYPE_COLUMN, historyObject.INPUT_TYPE);
        content.put(history.INPUT_COLUMN, historyObject.INPUT);
        content.put(history.OUTPUT_TYPE_COLUMN, historyObject.OUTPUT_TYPE);
        content.put(history.OUTPUT_COLUMN, historyObject.OUTPUT);

        long addHistory = db.insert(history.TABLE_NAME, null, content);
    }

    @SuppressLint("Range")
    public ArrayList<HISTORY> getAllHistory(Context context) {
        schemas = new Schemas(context);
        ArrayList<HISTORY> arrayOfHistories = new ArrayList<HISTORY>();

        history = new Schemas.History();

        db = schemas.getWritableDatabase();

        String columns[] = history.columns;

        String orderBy = history.ID_COLUMN + " ASC";

        Cursor cursor = db.query(history.TABLE_NAME, columns, null, null,
                null, null, orderBy);

        while (cursor.moveToNext()) {
            arrayOfHistories.add(new HISTORY(cursor.getLong(cursor.getColumnIndex(columns[0])),
                    cursor.getString(cursor.getColumnIndex(columns[1])),
                    cursor.getString(cursor.getColumnIndex(columns[2])),
                    cursor.getString(cursor.getColumnIndex(columns[3])),
                    cursor.getString(cursor.getColumnIndex(columns[4]))
            ));
        }
        return arrayOfHistories;
    }

    public void deleteAllHistories(Context context) {
        schemas = new Schemas(context);
        history = new Schemas.History();

        db = schemas.getWritableDatabase();
        String Clause = "1";
        String args[] = new String[0];

        long deleteAllHistory = db.delete(history.TABLE_NAME, Clause, args);
    }

    public void deleteHistory(HISTORY historyObject, Context context) {
        schemas = new Schemas(context);
        history = new Schemas.History();

        db = schemas.getWritableDatabase();
        String Clause = history.ID_COLUMN + " == " + "?";
        String args[] = {String.valueOf(historyObject.ID)};

        long deleteHistory = db.delete(history.TABLE_NAME, Clause, args);
    }
}
