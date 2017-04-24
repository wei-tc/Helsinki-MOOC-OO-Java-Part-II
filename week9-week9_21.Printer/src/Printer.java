/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author W
 */
public class Printer {
    private Scanner reader;
    private List<String> lines;
    
    public Printer(String fileName) throws Exception {
        this.reader = new Scanner(new File(fileName));
        this.lines = new ArrayList<String>();
        
        while (this.reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
    }
 
    public void printLinesWhichContain(String word) throws Exception {
        for (String string : this.lines) {
            if (string.contains(word)) {
                System.out.println(string);
            }
        }
    }
}
