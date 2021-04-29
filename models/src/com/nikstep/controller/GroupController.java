package com.nikstep.controller;

import com.nikstep.entity.Group;
import com.nikstep.entity.Student;
import com.nikstep.repository.GroupRepository;

import java.util.Scanner;

public class GroupController implements Runnable {
    private final int id;
    Scanner in = new Scanner(System.in);


    public GroupController(int id){ this.id = id;}


    @Override
    public void run() {
        while (true){
            switch (showMenu()){
                case 0: return;
                case 1:
                    createStudent();
                    break;
                case 2:
                    showAllStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                default:
                    System.out.println(" Я не понял вашу команду \n\n");
            }
        }
    }


    private void createStudent() {
        System.out.print(" Введите имя студента: ");
        String name = in.nextLine();
        System.out.print(" Вес: ");
        int w = in.nextInt(); in.nextLine();
        System.out.print(" Рост: ");
        int h = in.nextInt(); in.nextLine();

        GroupRepository.getInstance().read(id).students.add( new Student(name, w,h));
    }

    private void showAllStudents() {
        int i = 0;
        if (GroupRepository.getInstance().read(id).students.size() == 0){
            System.out.println(" в этой группе нет студентов");
            return;
        }
        for (Student s: GroupRepository.getInstance().read(id).students ) {
            System.out.println((i++) + " => " + s);
        }
    }

    private void updateStudent() {
    }

    private void deleteStudent() {
        System.out.print(" какого студента удалить: ");
        int num = in.nextInt();
        in.nextLine();
        try {
            GroupRepository.getInstance().read(id).students.remove(num);
        }catch (Exception ex) {
            System.out.println(" не могу удалить студента: " + ex.getMessage());
        }
    }
    /**
     * Центральное меню пользователя
     * @return выбор пользователя
     */
    private int showMenu(){
        int res = 0;

        System.out.println(" ");
        System.out.println("1 - (C) создать студента ");
        System.out.println("2 - (R) посомтреть студентов ");
        System.out.println("3 - (U) отредактировать студента ");
        System.out.println("4 - (D) удалить студента ");
        System.out.println("-------------------------");
        System.out.println("0 - выйти из группы");
        System.out.print("Введите команду: ");

        res = in.nextInt();  //cin (int)
        in.nextLine(); // Очищает буфер клавиатуры

        return res;
    }
}
