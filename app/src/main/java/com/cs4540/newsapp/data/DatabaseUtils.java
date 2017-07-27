package com.cs4540.newsapp.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static com.cs4540.newsapp.data.Contract.TABLE_ARTICLES.*;

/**
 * Created by seppc_laptop on 7/26/2017.
 */

public class DatabaseUtils {

    //SQLite query that selects all from the database
    public static Cursor getAll(SQLiteDatabase db) {
        Cursor cursor = db.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                COLUMN_NAME_PUBLISHED_DATE + " DESC"
        );
        return cursor;
    }

    //inserts the data into the database from an arraylist of articles
    public static void bulkInsert(SQLiteDatabase db, ArrayList<Article> articles) {

        db.beginTransaction();
        try {
            for (Article a : articles) {
                ContentValues cv = new ContentValues();
                cv.put(COLUMN_NAME_TITLE, a.getTitle());
                cv.put(COLUMN_NAME_AUTHOR, a.getAuthor());
                cv.put(COLUMN_NAME_DESCRIPTION, a.getDescription());
                cv.put(COLUMN_NAME_PUBLISHED_DATE, a.getPublished_date());
                cv.put(COLUMN_NAME_URL, a.getUrl());
                cv.put(COLUMN_NAME_IMAGE_URL, a.getImageUrl());
                db.insert(TABLE_NAME, null, cv);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }

    public static void deleteAll(SQLiteDatabase db) {
        db.delete(TABLE_NAME, null, null);
    }

}
