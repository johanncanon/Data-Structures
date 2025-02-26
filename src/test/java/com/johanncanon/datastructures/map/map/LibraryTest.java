package com.johanncanon.datastructures.map.map;

import com.johanncanon.datastructures.map.hashmap.Dictionary;
import com.johanncanon.datastructures.map.hashmap.Library;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Dictionary spanishDictionary;
    private Map<String, List<String>> wordMapTest;
    private List<String> meaninsList;
    private String meaning1, meaning2, meaning3, meaning4;
    private String word1;

    @BeforeEach
    void setUp() {
        meaning1 = "Alimento a medio cocer.";
        meaning2 = "Guiso típico de las islas Canarias a base de papa, batata, pescado desalado y mojo picón.";
        meaning3 = "Bol., Col., Ec., Guat., Hond., Nic., Pan., Perú, P. Rico, R. Dom. y Ven. Olla compuesta de carne, " +
                "yuca, plátano y otros ingredientes, y que se toma en el almuerzo.";
        meaning4 = "Bol., C. Rica, Nic., Perú y R. Dom. revoltijo (‖ conjunto de cosas sin orden).";
        meaninsList = List.of(meaning1, meaning2, meaning3, meaning4);
        word1 = "Sancocho";
        wordMapTest = new HashMap<>();
        wordMapTest.put(word1, meaninsList);
        spanishDictionary = new Dictionary( "spanish", wordMapTest );
        library = new Library( spanishDictionary );
    }

    @AfterEach
    void afterEach() {
        library = null;
        spanishDictionary = null;
        wordMapTest = null;
        meaninsList = null;
    }

    @Test
    void testAddingNewWordToASpanishLibrary() {
        var response = library.addNewWordToDictionary( "Alfabeto", List.of( "m. abecedario (‖ serie, o lista).",
                "Conjunto de los símbolos empleados en determinados sistemas de comunicación." ));
        assertEquals(  "New word added to spanish dictionary: Alfabeto", response );
        var alfabeto = library.getDictionary().getMeaningByWord("Alfabeto").values()
                .stream()
                .findFirst()
                .get()
                .getFirst();
        assertEquals( "m. abecedario (‖ serie, o lista).", alfabeto);
    }

    @Test
    void testGettingAllMeaningsFromTheDictionaryWord() {
        var response = library.getAllMeaningsByWord(word1);
        assertTrue( response.containsKey( word1 ) );
        var meanings = List.of(
                "f. Hembra del toro, de la que se obtiene principalmente carne y leche.",
                "f. Carne de vaca o de buey, que se emplea como alimento."
        );
        var newWordTest = library.addNewWordToDictionary( "Vaca", meanings );
        assertEquals( "New word added to spanish dictionary: Vaca" , newWordTest );
        var meaningsTest = library.getAllMeaningsByWord("Vaca");
        assertTrue( meaningsTest.containsKey( "Vaca" ) );
        var meaningsListTest = meaningsTest.get( "Vaca" );
        assertEquals( "f. Hembra del toro, de la que se obtiene principalmente carne y leche.", meaningsListTest.getFirst() );

    }
}