package com.johanncanon.datastructures.map.hashmap;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Getter
public class Library {

    private final Dictionary dictionary;

    public Library(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String addNewWordToDictionary(String word, List<String> meanings) {
        log.debug("Adding new word to spanish dictionary: {}", word);
        this.dictionary.addWordToDictionary( word, meanings );
        return "New word added to spanish dictionary: " + word;
    }

    public Map<String, List<String>> getAllMeaningsByWord(String word) {
        log.debug("Getting all meanings by word: '{}'", word);
        if (!this.dictionary.getWordMap().containsKey(word)) {
            log.debug("Word '{}' not found", word);
            return new HashMap<>();
        }
        return this.dictionary.getMeaningByWord( word );
    }


}
