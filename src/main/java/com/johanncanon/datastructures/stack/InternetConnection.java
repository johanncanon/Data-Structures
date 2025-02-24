package com.johanncanon.datastructures.stack;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.Stack;

@Log4j2
@Getter
@Setter
public class InternetConnection {

    private Browser browser;

    public InternetConnection(Browser browser) {
        this.browser = browser;
    }

    /**
     * Using '.push( )' in Stack class, you can add a new record to your Stack collection. As well as '.peek( )'
     * when you need to get the last element.
     * @param url String
     * @return String
     */
    public String addNewWebsiteToHistory(String url) {
        Stack<String> urlHistory = new Stack<>();
        log.info("Adding '{}' new website to history.", url);
        urlHistory.push( url );
        this.browser.setBackStackButton( urlHistory );
        return "This url '"+ this.browser.getBackStackButton().peek() +"' has been added to the history.";
    }

    public String getLastWebsite() {
        log.info("Getting the last website from the history: {}" , this.browser.getBackStackButton().peek());
        return "This is the last website: " + this.browser.getBackStackButton().peek();
    }

    public String getBackToTheLastWebsiteButton() {
        log.info("Getting back stack button.");
        this.browser.getBackStackButton().pop();
        log.info("Back website stack button: {}", this.browser.getBackStackButton().peek());
        return "Backing to previews page: " + this.browser.getBackStackButton().peek();
    }


}
