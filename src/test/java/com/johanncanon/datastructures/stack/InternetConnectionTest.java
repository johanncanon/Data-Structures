package com.johanncanon.datastructures.stack;

import org.junit.jupiter.api.*;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class InternetConnectionTest {

    private InternetConnection internetConnection;
    private Browser browser;
    private Stack<String> stackUrls;

    @BeforeEach
    void beforeEach() {
        stackUrls = new Stack<>();
        stackUrls.push("https://www.google.com");
        stackUrls.push("https://www.microsoft.com");
        stackUrls.push("https://www.chat.openai.com/8726348628723486");
        browser = new Browser( "adsBlocked", "https://www.facebook.com", stackUrls );
        internetConnection = new InternetConnection(browser);
    }

    @AfterEach
    void tearDown() {
        internetConnection = null;
        browser = null;
        stackUrls = null;
    }

    @Test
    void testAddingNewWebsiteToTheStackOfTheBrowser() {
        var stackTest = stackUrls;
        stackTest.push("https://www.hotmail.com.co");
        var browserTest = new Browser( stackTest );
        var internetConnTest = new InternetConnection( browserTest );
        browserTest.setUrl( "https://www.precidencia.com.co" );
        assertEquals( "https://www.precidencia.com.co", browserTest.getUrl() );
        assertEquals( "https://www.hotmail.com.co", browserTest.getBackStackButton().peek() );
        assertEquals( "This url 'https://www.yahoo.com.co' has been added to the history.", internetConnTest.addNewWebsiteToHistory("https://www.yahoo.com.co") );
    }


    @Test
    void testGettingLastWebsiteFromTheStackOfTheBrowser() {
        var stackTest = stackUrls;
        var browserTest = new Browser( stackTest );
        var internetConnTest = new InternetConnection( browserTest );
        assertEquals( "This is the last website: https://www.chat.openai.com/8726348628723486" , internetConnTest.getLastWebsite() );
        internetConnTest.addNewWebsiteToHistory("https://www.indu.com.co");
        assertEquals( "This is the last website: https://www.indu.com.co" , internetConnTest.getLastWebsite() );
    }

    @Test
    void testGettingBackToTheLastWebsite() {
        var stackTest = stackUrls;
        var browserTest = new Browser( stackTest );
        var internetConnTest = new InternetConnection( browserTest );
        assertEquals( "Backing to previews page: https://www.microsoft.com" , internetConnTest.getBackToTheLastWebsiteButton() );
    }
}