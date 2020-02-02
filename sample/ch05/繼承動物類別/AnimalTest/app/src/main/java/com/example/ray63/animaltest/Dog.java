package com.example.ray63.animaltest;

/**
 * Created by ray63 on 2018/1/27.
 */

public class Dog extends Animal {
    Dog(String name) {
        super(name);
        this.weight = 15;
        this.height = 8;
    }
    String eat()
    {
        return "eat a bone!";
    }
}
