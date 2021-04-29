package com.nikstep.controller;
/**
 * Контроллер Деканат
 * -------------------------------------------------------------------------
 * Выводить меню, принимать запрос (выбор) пользователя
 * Согласно выбору пользователя выполнять операции с данными
 * Проверять правильность ввода данных
 */

import com.nikstep.entity.Group;
import com.nikstep.repository.GroupRepository;

import java.util.Scanner;

public class Deanery implements Runnable {
    Scanner in = new Scanner(System.in);
    /**
     * Точка входа в деканат
     * Анализирует выбор пользователя, и запускает нужный метод
     */
    @Override
    public void run() {
        while (true){
            switch (showMenu()){
                case 0: return;
                case 1:
                    createGroup();
                    break;
                case 2:
                    showAllGroup();
                    break;
                case 3:
                    updateGroup();
                    break;
                case 4:
                    deleteGroup();
                    break;
                default:
                    System.out.println(" Я не понял важу команду \n\n");
            }
        }

    }

    private void updateGroup() {
        System.out.print(" Какую группу обновлять: ");
        int num = in.nextInt();
        in.nextLine();
        System.out.print(" Введите новое имя: ");
        GroupRepository.getInstance().read(num).name = in.nextLine();
    }


    private void deleteGroup() {
        System.out.print(" Какую группу удалить: ");
        GroupRepository.getInstance().delete(in.nextInt());
        in.nextLine();
    }

    /**
     * Ввод новой группы
     */
    private void createGroup() {
        System.out.print("Создадим новую группу - дайте ей имя: ");
        GroupRepository.getInstance().create( new Group( in.nextLine()));
    }


    /**
     * Вывести все группы
     */
    private void showAllGroup() {
        System.out.println("\n------------------------ \nСписок всех груп: ");
        int i = 0;
        for (Group g:GroupRepository.getInstance().readAll() ) {
            System.out.println((i++) + " => " + g);
        }
        System.out.println("------------------------ \n");
    }

    /**
     * Центральное меню пользователя
     * @return
     */
    private int showMenu(){
        int res = 0;

        System.out.println("");
        System.out.println("1 - (C) создать группу ");
        System.out.println("2 - (R) посомтреть все группы");
        System.out.println("3 - (U) отредактировать группу ");
        System.out.println("4 - (D) удалить группу");
        System.out.println("-------------------------");
        System.out.println("0 - выйти из программы");
        System.out.print("Введите команду: ");

        res = in.nextInt();  //cin (int)
        in.nextLine(); // Очищает буфер клавиатуры

        return res;
    }

}
