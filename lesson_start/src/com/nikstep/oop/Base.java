package com.nikstep.oop;

public class Base {
    // модификатор доступа Тип Имя
    private String name;

    public Base(){
        System.out.println("NoParam Base is Created");
    }

    /**
     * Конструктор Base с параметром
     * @param name
     */
    public Base(String name){
       this.name = name;
       System.out.println("Base is Created");
    }

    public Base (Integer i){
        System.out.println("Base + Integer is Created");
    }


}
