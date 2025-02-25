package com.johanncanon.datastructures.map.map;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@Log4j2
public class Dictionary {

    private String idiom;
    private Map<String, List<String>> wordMap;

    public Dictionary(String idiom, Map<String, List<String>> wordMap) {
        this.idiom = idiom;
        this.wordMap = wordMap;
    }

    public String addWordToDictionary(String word, List<String> meanings) {
        log.debug("Adding word: {}", word);
        this.wordMap.put(word, meanings);
        return "New word '"+ wordMap.get( word ) +"' added successfully";
    }

    public Map<String, List<String>> getMeaningByWord( String word ){
        log.debug("Getting meaning by word: {}", word);
        var meaningByWord = new HashMap<String, List<String>>();
        meaningByWord.put( word, wordMap.get( word ) );

        // Get all the meanings from the meaning's list and create a String separated by comas
        var logMeanings = meaningByWord.values()
                .stream()
                        .flatMap(List::stream)
                                .collect(Collectors.joining());
        log.debug("Meaning by word: {}", logMeanings );
        return meaningByWord;
    }
}
