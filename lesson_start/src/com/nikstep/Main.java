package com.nikstep;

import com.nikstep.aprl15.*;
import com.nikstep.oop.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    /**
     * работа за 15 апреля
     */
    public static void main(String[] args) {
        ArrayList<Animal> myAnimals = new ArrayList<>();
        System.out.print(" Сколько у вас домашних животных: ");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Random rnd = new Random();
        int r;
        for( int i =0; i < count; i++) {
            r = rnd.nextInt(2);
            switch (r){
                case 1:
                    myAnimals.add(new Fish(" Рыбка " + i));
                    break;
                case 2:
                    myAnimals.add(new Triton(" Тритон " + i));
                    break;
            }
            /*
            if () {} else if() {} .... else {}
             */
        }

        System.out.println(" В моем зоопарке: ");
        for (int i = 0; i < myAnimals.size(); i++) {
            System.out.println(myAnimals.get(i));
        }


    }

    public void aprl15_2(){
        Fish f = new Fish("Фреди");
        System.out.println("Класс переменной f: " + f.getClass());
        if(f instanceof HomeAnimal) {
            System.out.println(" Но он еще и домажнее животное");
        }
        if(f instanceof Animal) {
            System.out.println(" Но он еще и животное");
        }
        if(f instanceof WaterFowl){
            f.toSwim();
        }

        System.out.println(f);
    }


    public void arpl15_1(){
        // Поддержка анонимных классов, когда на основе класса прямо в коде создается наследник
        // Внимание!!! экземпляр класса будет наследником от животного, а не животным!!!
        Animal cobra = new Animal(" Ее кобра") {

            /**
             * Реализация абстрактной функции - без которой не возможно сщуествование животного
             */
            @Override
            public void doEat() {
                System.out.println(" Кобра ест мышек ");
                hood();
            }

            // Создали метод
            // Вызвать в прямую описанный в анонимном классе метод не представляется возможным
            // поскольку мы не сможем обратиться к обьекту как к сущности. У этой сщуности нет класса
            public void hood(){
                System.out.println(" У кобры есть капюшон, и он только у нее");
            }
        };

        System.out.println("Класс переменной кобра: " + cobra.getClass());
        cobra.doEat();

        // невозможно создать экземпляр абстрактного класса
        // Animal a = new Animal("Просто животное");
    }

    /**
     * Работа за 13 апреля
     * @param args
     */
    public static void main13(String[] args) {
        Random rnd = new Random();

        ArrayList<Gamer> lstPlayers = new ArrayList<>();

        // Цикл - что бы создать 5 врагов
        for (int i = 0; i < 5; i++) {
            // Случайным образов создаю врага
            if (rnd.nextBoolean()){
                // Или простого варвара
                lstPlayers.add(new Dragon());
            } else {
                // Или продвинутого
                lstPlayers.add(new Arch());
            }
        }

        for (int i = 0; i < lstPlayers.size(); i++) {
            lstPlayers.get(i).doAttack();
            if(lstPlayers.get(i) instanceof IFly){
                ((IFly) lstPlayers.get(i)).doFly();
            }
        }


        /*

        // Создаю коллекцию врагов
        ArrayList<Base> lstPlayers = new ArrayList<>();
        // Включаю генератор случайных чисел
        Random rnd = new Random();

        // Цикл - что бы создать 5 врагов
        for (int i = 0; i < 5; i++) {
            // Случайным образов создаю врага
            if (rnd.nextBoolean()){
                // Или простого варвара
                lstPlayers.add(new Warvar());
            } else {
                // Или продвинутого
                lstPlayers.add(new WarVarArch());
            }
        }

        // Цикл битвы (один ход)
        for (int i = 0; i < lstPlayers.size(); i++) {
            ((Warvar) lstPlayers.get(i)).HandAttack();
            if(lstPlayers.get(i) instanceof WarVarArch){
                ((WarVarArch) lstPlayers.get(i)).Arch();
            }
        }



         */





        /*
        // Я собираю коллекцию живых существ
        ArrayList<Base> lstFriends = new ArrayList<Base>();
        // Я добавляю в коллецию студента
        lstFriends.add(new Student("Vasya"));
        // Добавляю человека
        lstFriends.add(new Human("Papa"));

        // Я перебираю свою коллекцию
        for (int i = 0; i < lstFriends.size(); i++){
            // Обращаюсь к элементу как к человеку
            ((Human) lstFriends.get(i)).iThinking();

            // Если это еще и студент - то обращаюсь к нему как к студенту
            if(lstFriends.get(i) instanceof Student){
                ((Student) lstFriends.get(i)).iLearning();
            }
        }

         */




        /**
         * Возможности хранения и обращения к объектам разного типа
         */
        // Human b = new Student("Olexander");
        // b.iThinking();
        // ((Student) b).iLearning();
        // ((Object) b).toString();





        /**
         * Процесс создания экземпляра класса
         * Конструкторы с параметрами и без
         * Директива super и порядок вызова конструкторов
         */
        //Base b = new Base("Vasya");
        //Human h = new Human("Petya");



    }
}
