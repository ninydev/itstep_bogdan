package com.nikstep.aprl15;

public class Triton extends HomeAnimal implements WaterFowl, GroundFowl{
    /**
     * Создадим конструктор, который позволит нам передавать имя животного
     * в коснтурктор предка
     */
    public Triton(String name) {
        super(name);
    }

    @Override
    public void toWalk() {

    }

    @Override
    public void toSwim() {

    }
}
