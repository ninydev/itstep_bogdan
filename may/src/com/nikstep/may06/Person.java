package com.nikstep.may06;

public class Person {

    public String name;
    public int weight;
    public int height;

    public Person(String name, int w, int h) {
        this.name = name;
        this.weight = w;
        this.height = h;
    }

    @Override
    public String toString() {
        return "Person{" +
                " name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
