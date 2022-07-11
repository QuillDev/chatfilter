package com.minehut.chatfilter.loader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class ChatFilterIO {

    /**
     * Load the word list from the given file name
     * @param path to load words from
     * @return the word list
     */
    public Set<String> loadWordList(Path path) {

        final Set<String> words = new HashSet<>();
        try {
            // create if it doesn't exist
            if(!Files.exists(path)){
                path.getParent().toFile().mkdirs();
                Files.createFile(path);
            }

            // add all the words to the list
            words.addAll(Files.readAllLines(path));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return words;
    }
}
