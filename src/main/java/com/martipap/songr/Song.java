package com.martipap.songr;


import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @ManyToOne
    Album album;

    long id;
    public String title;
    public int length;
    public int trackNumber;

    public Song() {

    }




}
