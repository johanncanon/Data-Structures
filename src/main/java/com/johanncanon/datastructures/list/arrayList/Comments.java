package com.johanncanon.datastructures.list.arrayList;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Objects;

@Log4j2
public class Comments {

    private ArrayList<String> comments;

    public Comments() {
    }

    public Comments(ArrayList<String> comments) {
        this.comments = comments;
    }


    public void addComment( String comment ) {
        log.info("Adding comment to list: {}", comment);
        if (Objects.isNull(comments)  || comments.isEmpty()) comments = new ArrayList<>();
        else this.comments.add( comment );
        log.info("Total comments by user: {}", comments.size());
    }

    public String removeCommentByIndex( int index ) {
        if (Objects.isNull(comments) || comments.isEmpty()){
            comments = new ArrayList<>();
            return "List is empty";
        }
        else{
            log.info("List index: {}, value: {}", index, comments.get(index) );
            this.comments.remove( index );
            log.info("Removed comment. Next content from the list with the same index: {}", comments.get(index) );}
        return "Removed comment.";
    }

    public ArrayList<String> getComments() {
        if (Objects.isNull(comments)){
            comments = new ArrayList<>();
            return new ArrayList<>();
        }
        else{
            log.info("ArrayList Content: {}", String.join(", ", comments));
            return this.comments;
        }
    }

    public String getCommentByIndex( int index ) {
        if (Objects.isNull(comments) || comments.isEmpty() ){
            return "List is empty";
        }
        else{
            log.info("List index: {}, List value: {}", index, comments.get(index) );
            return this.comments.get( index );
        }
    }

}
