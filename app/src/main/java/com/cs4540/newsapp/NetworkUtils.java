package com.cs4540.newsapp;

import android.net.Uri;
import android.util.Log;

import com.cs4540.newsapp.data.Article;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static android.content.ContentValues.TAG;

/**
 * Created by seppc_laptop on 7/26/2017.
 */

public class NetworkUtils {
    public static final String TAG = "NetworkUtils";

    private static final String BASE_URL = "https://newsapi.org/v1/articles";

    final static String QUERY_PARAM = "source";
    final static String PARAM_SORT = "sort";
    final static String sortBy = "latest";
    final static String apiKey = "apiKey";

    final static String key = "aaf358e7f6e844948361a06b15c5903d";

    //creates url for database
    //https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=aaf358e7f6e844948361a06b15c5903d
    public static URL makeURL(String newsQuery) {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, newsQuery)
                .appendQueryParameter(PARAM_SORT, sortBy)
                .appendQueryParameter(apiKey, key)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Log.v(TAG, "Built URI " + url);
        return url;
    }

    //reads output json from url
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner input = new Scanner(in);

            input.useDelimiter("\\A");
            String result = (input.hasNext()) ? input.next() : null;
            return result;

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return null;
    }

    //parses output json into an arraylist of articles
    public static ArrayList<Article> parseJSON(String json) throws JSONException {
        ArrayList<Article> result = new ArrayList<>();
        JSONObject main = new JSONObject(json);
        JSONArray items = main.getJSONArray("articles");

        for(int i = 0; i < items.length(); i++){
            JSONObject item = items.getJSONObject(i);
            String title = item.getString("title");
            String author = item.getString("author");
            String description = item.getString("description");
            String publishedDate = item.getString("publishedAt");
            String url = item.getString("url");
            String imageUrl = item.getString("urlToImage");

            result.add(new Article(title, author, description, publishedDate, url, imageUrl));

        }
        Log.d(TAG, "final articles size: " + result.size());
        return result;
    }


}
