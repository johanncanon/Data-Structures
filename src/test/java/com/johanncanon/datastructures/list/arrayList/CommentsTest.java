package com.johanncanon.datastructures.list.arrayList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CommentsTest {

    @Test
    void testAddingNewObjectToArrayList() {
        var testComment1 = "This is a comment1";
        var testComment2 = "This is a comment2";
        var testComment3 = "This is a comment3";
        var testComment4 = "This is a comment4";
        var testCommentTEST = "This is a comment TEST";
        Comments comments = new Comments( new ArrayList<>(Arrays.asList(testComment1, testComment2, testComment3, testComment4)) );
        comments.addComment( testCommentTEST );
        assertEquals( testCommentTEST, comments.getCommentByIndex( 4 ) );
    }

    @Test
    void testAddingNewObjectEmpty() {
        var emptyListResponse  = "List is empty";
        Comments comments = new Comments();
        comments.addComment( "This is a comment" );
        assertEquals( emptyListResponse, comments.getCommentByIndex( 0 ) );
    }

    @Test
    void testRemovingContentByIndexIsWorking() {
        var testComment1 = "This is a comment1";
        var testComment2 = "This is a comment2";
        var testComment3 = "This is a comment3";
        var testComment4 = "This is a comment4";
        var result = "Removed comment.";
        Comments comments = new Comments( new ArrayList<>(Arrays.asList(testComment1, testComment2, testComment3, testComment4)) );
        assertEquals( result, comments.removeCommentByIndex( 2 ) );
    }


    @Test
    void testAllCommentsFromTheArrayList() {
        var testComment1 = "This is a comment1";
        var testComment2 = "This is a comment2";
        var testComment3 = "This is a comment3";
        var testComment4 = "This is a comment4";
        ArrayList<String> expectedComments = new ArrayList<>(Arrays.asList(testComment1, testComment2, testComment3, testComment4));
        var result = "Removed comment.";
        Comments comments = new Comments( expectedComments );
        assertEquals( expectedComments, comments.getComments() );
    }
}