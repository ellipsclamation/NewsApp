package com.cs4540.newsapp.data;

import android.provider.BaseColumns;

/**
 * Created by seppc_laptop on 7/26/2017.
 */

public class Contract {

    //constants used for the SQLite database
    public static class TABLE_ARTICLES implements BaseColumns {
        public static final String TABLE_NAME = "articles";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_AUTHOR = "author";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_PUBLISHED_DATE = "published_date";
        public static final String COLUMN_NAME_URL = "url";
        public static final String COLUMN_NAME_IMAGE_URL = "image_url";
    }
}
