package com.nikstep.aprl15;

public class Fish extends HomeAnimal implements WaterFowl{
    /**
     * Создадим конструктор, который позволит нам передавать имя животного
     * в коснтурктор предка
     * @param name
     */
    public Fish(String name) {
        super(name);
        System.out.println("+ Создана новая рыбка");
    }

    /**
     * Реализация интерфейса для водоплавующего животного
     */
    @Override
    public void toSwim() {
        System.out.println(" Рыбка плавает в воде ");
    }
}
