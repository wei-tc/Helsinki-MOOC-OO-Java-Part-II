/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author W
 */
public class WordInspection {
    private final String vowels = "aeiouyäö";
    private Scanner reader;
    private List<String> words;

    public WordInspection(File file) throws Exception {
        this.words = new ArrayList<String>();
        this.reader = new Scanner(file, "UTF-8");
        
        while (this.reader.hasNextLine()) {
            this.words.add(this.reader.nextLine());
        }
    }

    public int wordCount() {
        return this.words.size();
    }

    public List<String> wordsContainingZ() {
        List<String> wordsContainingZ = new ArrayList<String>();

        for (String word : this.words) {
            if (word.contains("z")) {
                wordsContainingZ.add(word);
            }
        }
        return wordsContainingZ;
    }

    public List<String> wordsEndingInL() {
        List<String> wordsEndingInL = new ArrayList<String>();

        for (String word : this.words) {
            if (word.endsWith("l")) {
                wordsEndingInL.add(word);
            }
        }
        return wordsEndingInL;
    }

    public List<String> palindromes() {
        List<String> palindromes = new ArrayList<String>();

        for (String word : this.words) {
            String reverseWord = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseWord += word.charAt(i);
            }

            if (word.equals(reverseWord)) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsWhichContainAllVowels = new ArrayList<String>();

        for (String word : this.words) {
            if (containsAllVowels(word)) {
                wordsWhichContainAllVowels.add(word);
            }
        }
        return wordsWhichContainAllVowels;
    }
    
    private boolean containsAllVowels(String word) {
        for (char vowel : this.vowels.toCharArray()) {
            if (!word.contains("" + vowel)) {
                return false;
            }
        }
        return true;
    }

}
