package com.example.ray63.animaltest;

/**
 * Created by ray63 on 2018/1/27.
 */
public class Cat extends Animal {

    Cat(String name) {
        super(name);
        this.weight = 10;
        this.height = 5;
    }
    String eat()
    {
        return "eat a fish!";
    }
}
