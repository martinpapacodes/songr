package com.martipap.songr;

public class Album {
   public String title;
   public String artist;
   public int songCount;
   public int length;
   public String imageUrl;

    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }
}
