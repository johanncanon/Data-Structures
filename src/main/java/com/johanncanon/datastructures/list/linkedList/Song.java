package com.johanncanon.datastructures.list.linkedList;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Song {

    private String title;
    private String artist;

    public Song() {
    }

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

}
