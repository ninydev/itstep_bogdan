package com.nikstep.aprl15;

public class HomeAnimal extends Animal {
    /**
     * Создадим конструктор, который позволит нам передавать имя животного
     * в коснтурктор предка
     */
    public HomeAnimal(String name) {
        super(name);
        System.out.println("+ Создано новое домашнее животное");

    }

    /**
     * Опишем, как мы будем кормить домашнее животное
     */
    @Override
    public void doEat() {
        System.out.println(" Домашнее животное ест магазинную еду, или доетает все со стола ");
    }
}
