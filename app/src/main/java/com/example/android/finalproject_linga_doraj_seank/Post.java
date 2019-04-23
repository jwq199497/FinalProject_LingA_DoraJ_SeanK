package com.example.android.finalproject_linga_doraj_seank;

public class Post {
    String photoUrl;
    String title;
    String author;
    String liked;

    public Post(String photoUrl, String title, String author, String liked) {
        this.photoUrl = photoUrl;
        this.title = title;
        this.author = author;
        this.liked = liked;
    }

    public Post() {
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getLiked() {
        return liked;
    }
}
