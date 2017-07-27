package com.cs4540.newsapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cs4540.newsapp.data.Article;
import com.cs4540.newsapp.data.DBHelper;
import com.cs4540.newsapp.data.DatabaseUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by seppc_laptop on 7/26/2017.
 */

public class RefreshTasks {
    //refreshes database with data from url

    public static final String ACTION_REFRESH = "refresh";


    public static void refreshArticles(Context context) {
        ArrayList<Article> result = null;
        URL url = NetworkUtils.makeURL("the-next-web");

        SQLiteDatabase db = new DBHelper(context).getWritableDatabase();

        try {
            DatabaseUtils.deleteAll(db);
            String json = NetworkUtils.getResponseFromHttpUrl(url);
            result = NetworkUtils.parseJSON(json);
            DatabaseUtils.bulkInsert(db, result);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (JSONException e) {
            e.printStackTrace();
        }

        db.close();
    }
}