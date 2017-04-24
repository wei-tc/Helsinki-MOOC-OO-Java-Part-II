/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author W
 */
public class Main {
    public static void main(String[] args) {
        Box box = new Box(10); 
        
        box.add(box);
        box.add(new Book("Fedor Dostojevski", "Crime and Punishment", 2));
        
        System.out.println(box);
    }
}
