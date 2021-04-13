package com.nikstep.oop;

public class Human extends Base {

    public Human(){
        System.out.println("NoParam Human is Created");
    }

    /**
     * Конструктор Human с параметром
     * @param name
     */
    public Human(String name) {
        //super(10);
        System.out.println("Human is Created");
    }

    public void iThinking(){
        System.out.println("Я думаю - значит я существую");
    }
}
