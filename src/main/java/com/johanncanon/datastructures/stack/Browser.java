package com.johanncanon.datastructures.stack;

import lombok.Getter;
import lombok.Setter;

import java.util.Stack;

@Setter
@Getter
public class Browser {

    private String widget;
    private String url;
    private Stack<String> backStackButton;



    /**
     * Stack (Pila), is a LIFO data structure (Last In First Out). It means that you can process always the last object
     * in your Stack. For instance, the backwards button from the browser, or the "undo" button from the IDE.
     *
     * @param backStackButton Stack<String> name
     */
    public Browser(Stack<String> backStackButton) {
        this.backStackButton = backStackButton;
    }

    public Browser(String widget, String url, Stack<String> backStackButton) {
        this.widget = widget;
        this.url = url;
        this.backStackButton = backStackButton;
    }



}
