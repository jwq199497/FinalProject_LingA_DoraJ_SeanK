package com.example.android.finalproject_linga_doraj_seank;

public class Post {
    String photoUrl;
    int title;
    int author;
    int liked;

    public Post(String photoUrl, int title, int author, int liked) {
        this.photoUrl = photoUrl;
        this.title = title;
        this.author = author;
        this.liked = liked;
    }

    public Post() {
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }
}
