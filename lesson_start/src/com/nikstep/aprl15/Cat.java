package com.nikstep.aprl15;

public class Cat extends HomeAnimal implements GroundFowl{
    /**
     * Создадим конструктор, который позволит нам передавать имя животного
     * в коснтурктор предка
     *
     * @param name
     */
    public Cat(String name) {
        super(name);
    }

    @Override
    public void toWalk() {

    }
}
