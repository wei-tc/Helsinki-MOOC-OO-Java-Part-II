/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phonesearch;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import Phonesearch.Phone;
import Phonesearch.Address;

/**
 *
 * @author W
 */
public class Person implements Comparable<Person> {

    private Map<String, Phone> numberByName;
    private Map<String, String> nameByNumber;
    private Map<String, Address> addressByName;
    private String name;

    public Person(String name, String number) {
        this.numberByName = new HashMap<String, Phone>();
        this.nameByNumber = new HashMap<String, String>();
        this.addressByName = new HashMap<String, Address>();
        this.name = name;

        this.numberByName.put(name, new Phone());
        this.numberByName.get(name).add(number);
        this.nameByNumber.put(number, name);
    }

    public Person(String name, String street, String city) {
        this.numberByName = new HashMap<String, Phone>();
        this.nameByNumber = new HashMap<String, String>();
        this.addressByName = new HashMap<String, Address>();
        this.name = name;

        this.addressByName.put(name, new Address());
        this.addressByName.get(name).setStreet(street);
        this.addressByName.get(name).setCity(city);
    }

    public boolean searchNumberByNameIsTrue(String name) {
        if (this.numberByName.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }

    public Set<String> printNumbers() {
        return this.numberByName.get(this.name).getNumbers();
    }

    public boolean searchNameByNumberIsTrue(String number) {
        if (this.nameByNumber.containsKey(number)) {
            return true;
        } else {
            return false;
        }
    }

    public String printName(String number) {
        return this.nameByNumber.get(number);
    }

    public void setAddress(String street, String city) {
        if (this.addressByName.get(this.name) == null) {
            this.addressByName.put(name, new Address());
        }

        this.addressByName.get(this.name).setStreet(street);
        this.addressByName.get(this.name).setCity(city);
    }

    public boolean searchAddressByNameIsTrue(String name) {
        if (this.addressByName.containsKey(name)) {
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public boolean nameIs(String name) {
        if (this.name.equals(name)) {
            return true;
        } else {
            return false;
        }
    }

    public Address printAddress() {
        return this.addressByName.get(this.name);
    }

    public void addNumber(String number) {
        this.nameByNumber.put(number, this.name);
        if (this.numberByName.get(this.name) != null) {
            this.numberByName.get(this.name).add(number);
        } else {
            this.numberByName.put(this.name, new Phone());
            this.numberByName.get(this.name).add(number);
        }
    }

    @Override
    public int compareTo(Person person) {
        return this.name.compareToIgnoreCase(person.name);
    }

    public boolean containsKeyword(String keyword) {
        if (this.addressByName.get(this.name) != null) {
            if (this.addressByName.get(this.name).addressContainsKeyword(keyword) || this.name.contains(keyword)) {
                return true;
            } else {
                return false;
            }
        } else {
            if (this.name.contains(keyword)) {
                return true;
            } else {
                return false;
            }
        }
    }
}
