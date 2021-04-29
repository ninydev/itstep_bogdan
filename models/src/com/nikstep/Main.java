package com.nikstep;
/**
 Створіть модель, яка б дозволяла розподіляти студентів по групам, переводити студентів з однієї групи в іншу,
 отримувати склад групи відсортований за алфавітом,чи за вагою,чи та зростом.

 Критерій сортування передається, як параметр методу. Модель повинна дозволяти шукати студентів в групі за прізвищем,
 фільтрувати за різними критеріями. Критерії передаються як параметри методу фільтрації.
 Виключити можливість додавання одного й того ж студента декілько разів у групу.
 */

import com.nikstep.controller.DeaneryController;
import com.nikstep.entity.Group;
import com.nikstep.entity.Student;
import com.nikstep.repository.GroupRepository;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Seed
        // Первоначальное наполнение данными
        Group g = new Group("PU911");
        g.students.add(new Student("иванов", 65, 185));
        GroupRepository.getInstance().create(g);
        GroupRepository.getInstance().create(new Group("qqq"));
        GroupRepository.getInstance().create(new Group("aaa"));

        DeaneryController d = new DeaneryController();
        d.run();


	// write your code here
    }

    public static void dz(){
        // PriorityQueue<String> queue = new PriorityQueue<String>();

        Deque<String> queue = new LinkedList<String>();

        queue.addFirst("первый пришел - первый вышел");
        queue.addFirst("3");
        queue.addFirst("3");
        queue.addFirst("4");
        queue.addFirst("последний пришел - последний вышел");
        // queue.add("0");

        for (String p:queue) {
            System.out.println(p);
        }

        while (!queue.isEmpty()) {
            // String p = queue.pollLast();
            String p = queue.pollFirst();
            System.out.println("Удалил из очереди: " + p);
        }

    }
}
