/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author W
 */
public class MindfulDictionary {

    private Map<String, String> dictionary;
    private File file;

    public MindfulDictionary() {
        this.dictionary = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) throws FileNotFoundException {
        this();
        this.file = new File(file);
    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(this.file);
            readFileIntoDictionary(reader);
            reader.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void readFileIntoDictionary(Scanner reader) {
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] parts = line.split(":");

            this.dictionary.put(parts[0], parts[1]);
            this.dictionary.put(parts[1], parts[0]);
        }
    }

    public void add(String word, String translation) {
        if (!this.dictionary.containsKey(word)) {
            this.dictionary.put(word, translation);
            this.dictionary.put(translation, word);
        }
    }

    public String translate(String word) {
        return this.dictionary.get(word);
    }

    public void remove(String word) {
        String translation = translate(word);

        this.dictionary.remove(word);
        this.dictionary.remove(translation);
    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(this.file);
            saveWords(writer);
            writer.close();
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    private void saveWords(FileWriter writer) throws IOException {
        List<String> alreadyInFile = new ArrayList<String>();

        for (String word : this.dictionary.keySet()) {
            String translation = this.dictionary.get(word);

            if (!alreadyInFile.contains(word)) {
                String pair = word + ":" + this.dictionary.get(word);
                writer.write(pair + "\n");
                alreadyInFile.add(translation);
            }
        }
    }
}
