package com.example.franklinsierra.labtabstoolbar.Models;

public class Person {

    //atributos
    private String name;
    private Country country;

    public Person(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
