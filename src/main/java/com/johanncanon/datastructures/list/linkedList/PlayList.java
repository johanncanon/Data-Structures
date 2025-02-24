package com.johanncanon.datastructures.list.linkedList;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.LinkedList;
import java.util.List;

@Log4j2
@Getter
public class PlayList {

    private String namePlayList;
    private LinkedList<Song> songs;

    public PlayList() {
    }

    public PlayList(String namePlayList, LinkedList<Song> songs) {
        this.namePlayList = namePlayList;
        this.songs = songs;
    }


    /**
     * Time complexity: O(n)
     * @param song object
     */
    public String addSong(Song song) {
        this.songs.add( song );
        return "Song ´"+ song.getTitle() +"´ added to PlayList.";
    }

    /**
     * Time complexity: O(1)
     * @param song object
     */
    public void addFirstSong(Song song) {
        this.songs.addFirst(song);
    }

    /**
     * Time complexity: O(1)
     * @param song object
     */
    public void addLastSong(Song song) {
        log.info("Adding song to playlist: {}", song.toString());
        this.songs.addLast(song);
    }

    public String addSongAtIndex(int index, Song song) {
        this.songs.add( index, song );
        return "Adding song at "+ index +", the song: "+ song +" , to playlist "+ namePlayList;
    }

    public void addSongsListAtIndex(int index, Song... songs) {
        var songsList = new LinkedList<Song>(List.of(songs));
        this.songs.addAll( index, songsList );
    }

    public String removeSong(Song song) {
        this.songs.remove(song);
       return "Song: '"+ song.getTitle() + "' has ben removed successfully.";
    }

    public void removeAllSongs( Song... songs ) {
        var songsList = new LinkedList<>( List.of(songs) );
        this.songs.removeAll( songsList );
    }


}
