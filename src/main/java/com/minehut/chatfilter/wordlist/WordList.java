package com.minehut.chatfilter.wordlist;

import com.minehut.chatfilter.loader.ChatFilterIO;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class WordList {

    private final ChatFilterIO io = new ChatFilterIO();
    private final Path listPath;

    public WordList(Path listPath) {
        this.listPath = listPath;
    }

    private Set<String> wordList = new HashSet<>();

    /**
     * reload the wordlist file
     */
    public void reload(){
        this.wordList = io.loadWordList(listPath);
    }

    /**
     * get the list of words from the wordlist
     * @return the wordlist
     */
    public Set<String> getWordList() {
        return wordList;
    }


}
