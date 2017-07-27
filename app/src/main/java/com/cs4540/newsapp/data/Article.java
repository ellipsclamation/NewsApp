package com.cs4540.newsapp.data;

/**
 * Created by seppc_laptop on 7/26/2017.
 */

public class Article{
    //POJO of an article

    private String title;
    private String author;
    private String description;
    private String published_date;
    private String url;
    private String imageUrl;

    //constructor that stores the data into an article object
    public Article(String title, String author, String description, String published_date, String url, String imageUrl) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.published_date = published_date;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

