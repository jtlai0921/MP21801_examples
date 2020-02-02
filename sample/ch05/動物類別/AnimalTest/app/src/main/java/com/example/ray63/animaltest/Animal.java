package com.example.ray63.animaltest;

/**
 * Created by ray63 on 2018/1/21.
 */

public class Animal {
    int age;
    int height;
    int weight;
    String name;
    Animal(String name)
    {
        this.age = 0;
        this.height = 0;
        this.weight = 0;
        this.name = name;
    }
    int grow()
    {
        this.age++;
        return this.age;
    }
    String eat()
    {
        return "don't know how to eat!";
    }
    String sleep()
    {
        return "don't know how to sleep!";
    }
}
