/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phonesearch;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author W
 */
public class UserInterface {

    private List<Person> phonebook;
    private Scanner reader;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.phonebook = new ArrayList<Person>();
    }

    public void start() {
        System.out.print("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit\n\n");
        this.readCommand();
    }

    public void readCommand() {
        while (true) {
            System.out.println("command: ");
            String command = reader.nextLine();
            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                this.addNumber();
            } else if (command.equals("2")) {
                this.searchNumberByName();
            } else if (command.equals("3")) {
                this.searchNameByNumber();
            } else if (command.equals("4")) {
                this.addAddress();
            } else if (command.equals("5")) {
                this.searchAddressPhoneByName();
            } else if (command.equals("6")) {
                this.deletePhoneAndAddress();
            } else if (command.equals("7")) {
                this.printAllNamesAndAddress();
            }
        }
    }

    public void addNumber() {
        System.out.println("whose number: ");
        String name = reader.nextLine();
        System.out.println("number: ");
        String number = reader.nextLine();

        for (Person person : this.phonebook) {
            if (person.nameIs(name)) {
                person.addNumber(number);
                return;
            }
        }

        this.phonebook.add(new Person(name, number));
    }

    public void searchNumberByName() {
        System.out.println("whose number: ");
        String name = reader.nextLine();

        for (Person person : this.phonebook) {
            if (person.searchNumberByNameIsTrue(name)) {
                for (String number : person.printNumbers()) {
                    System.out.println(" " + number);
                }
                return;
            }
        }

        System.out.println("  not found");
    }

    public void searchNameByNumber() {
        System.out.println("number: ");
        String number = reader.nextLine();
        for (Person person : this.phonebook) {
            if (person.searchNameByNumberIsTrue(number)) {
                System.out.println(" " + person.printName(number));
                return;
            }
        }

        System.out.println("  not found");
    }

    public void addAddress() {
        System.out.println("whose address: ");
        String name = reader.nextLine();
        System.out.println("street: ");
        String street = reader.nextLine();
        System.out.println("city: ");
        String city = reader.nextLine();
        for (Person person : this.phonebook) {
            if (person.nameIs(name)) {
                person.setAddress(street, city);
                return;
            }
        }

        this.phonebook.add(new Person(name, street, city));
    }

    public void searchAddressPhoneByName() {
        System.out.println("whose information: ");
        String name = reader.nextLine();

        for (Person person : this.phonebook) {
            if (person.nameIs(name)) {
                this.printAddress(name, person);
                this.printNumbers(name, person);
                return;
            }
        }

        System.out.println("  not found");
    }

    public void printAddress(String name, Person person) {
        if (person.searchAddressByNameIsTrue(name)) {
            System.out.println("  address: " + person.printAddress());
            return;
        } else {
            System.out.println("  address unknown");
        }
    }

    public void printNumbers(String name, Person person) {
        if (person.searchNumberByNameIsTrue(name)) {
            System.out.println("  phone numbers:");
            for (String number : person.printNumbers()) {
                System.out.println("   " + number);
            }
        } else {
            System.out.println("  phone number not found");
        }
    }

    public void deletePhoneAndAddress() {
        System.out.println("whose information: ");
        String name = reader.nextLine();

        for (Person person : this.phonebook) {
            if (person.nameIs(name)) {
                this.phonebook.remove(person);
                break;
            }
        }
    }

    public void printAllNamesAndAddress() {
        System.out.println("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();

        Collections.sort(this.phonebook);

        if (!keyword.equals("")) {
            boolean found = false;
            for (Person person : this.phonebook) {
                if (person.containsKeyword(keyword)) {
                    System.out.println("\n " + person.getName());
                    this.printAddress(person.getName(), person);
                    this.printNumbers(person.getName(), person);
                    found = true;
                }
            } if (found == false) {
                System.out.println("  not found");
            }
        } else {
            for (Person person : this.phonebook) {
                this.printAddress(person.getName(), person);
                this.printNumbers(person.getName(), person);
            }

        }
    }
}
