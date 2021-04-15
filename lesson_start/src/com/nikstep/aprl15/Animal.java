package com.nikstep.aprl15;

public abstract class Animal {
    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    /**
     * Заставит прогарммиста описать метод в наследнике
     */
    public abstract void doEat();

    /**
     * Конструктор, принимающий название животного
     * Таким образом создать животное без названия невозможно
     * Пока мы не создадим конструктор без парамтеров
     * @param name название
     */
    public Animal(String name){
        System.out.println("+ Создано животное");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
