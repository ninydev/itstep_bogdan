package com.nikstep;

import com.nikstep.helpers.arrays.ArrayInt;
import com.nikstep.oop.*;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
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
