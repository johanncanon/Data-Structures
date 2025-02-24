package com.johanncanon.datastructures.list.linkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayListTest {

    private static PlayList playList;
    private static LinkedList<Song> linkedList;
    private static Song song1;
    private static Song song2;
    private static Song song3;
    private static Song song4;

    @BeforeAll
    static void beforeAll() {
        song1 = new Song("The day thar never comes", "Metalica");
        song2 = new Song("Dusty blue", "Charles Bradley");
        song3 = new Song("One", "U2");
        song4 = new Song("In the dawn", "Manowar");
        linkedList = new LinkedList<>();
        linkedList.add(song1);
        linkedList.add(song2);
        linkedList.add(song3);
        linkedList.add(song4);
        playList = new PlayList("Hard Rock List", linkedList );
    }



    @Test
    void testAddingANewSongToTheLinkedList() {
        var songTest = new Song("The day thar never comes", "Metalica");
        var songTest2 = new Song("Like a Stone", "AudioSlave");
        var playListTest = playList;
        playListTest.addSong(songTest);
        assertEquals( playListTest.getNamePlayList(), playList.getNamePlayList() );
        assertEquals( playListTest.getSongs().getFirst().getTitle(), playList.getSongs().getFirst().getTitle() );
        assertEquals( playListTest.getSongs().getFirst().getArtist(), playList.getSongs().getFirst().getArtist() );
        assertEquals( "Song ´Like a Stone´ added to PlayList.", playListTest.addSong( songTest2 ) );

    }

    @Test
    void testAddFirstAndRemoveFirstSongInNewLinkedList() {
        var playListTest1 = playList;
        var songTest = new Song("Black Sabbat", "Black Sabbat");
        playListTest1.addFirstSong( songTest );
        assertEquals( playListTest1.getSongs().getFirst().getTitle(), songTest.getTitle() );
        assertEquals( "Song: 'Black Sabbat' has ben removed successfully.", playListTest1.removeSong(songTest) );

    }

    @Test
    void testAddAndRemoveSongLastInNewLinkedList() {
        var songTest = new Song("Salchipapas y Rock'n Roll", "Odio a Botero");
        var playListTest = playList;
        playListTest.addLastSong( songTest );
        assertEquals( playListTest.getSongs().getFirst().getTitle(), song1.getTitle() );
        assertEquals( playListTest.getSongs().getLast().getTitle(), songTest.getTitle() );
        playListTest.removeSong(songTest);
    }

    @Test
    void testRemoveAllSongsFromPlayList() {
        var playListTest = new PlayList("Test List", new LinkedList<>(List.of(song1, song2)));
        playListTest.removeAllSongs( song1, song2 );
        assertTrue( playListTest.getSongs().isEmpty() );
    }
}