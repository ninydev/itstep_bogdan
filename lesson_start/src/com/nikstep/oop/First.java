package com.nikstep.oop;

public class First {

    private int [] arr;
    int size;
    public int[] insert (int toInsert, int pos){
        int [] newArr = new int[size + 1];
        for (int i =0; i < pos; i++) {
            newArr[i] = arr[i];
        }
        newArr[pos] = toInsert;

        for (int i = pos+1; i < size+2; i++) {
            newArr[i] = arr[i-1];
        }

        arr = newArr;
        size++;
        return arr;
    }

    // public, private, protected
    private First(){
        System.out.println("First is create");
    }

    // Конструкторы
    public First(int i){
        someInt = i;
        System.out.println("First whis params int");
    }

    public First(String someString){
        System.out.println("First whis params string");
    }

    @Override
    public String toString() {
        return "First{" +
                "someInt=" + someInt +
                '}';
    }

    // Реализация одиночки
    private static First instance;
    public First getInstance(){
        if (instance == null){
            instance = new First();
        }
        return instance;
    }

    // Где храняться данные
    private int someInt; // С# {get; set;}

    // Геттер
    public int getSomeInt() {
        return someInt;
    }

    // Сетер
    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }



    public static String someVar = "Hello Static"; // Будет существовать даже когда нет экземпляра класса



}
