package com.nikstep.may06;

import java.util.Random;
import java.util.TreeSet;

public class SortBegin implements Runnable {

    @Override
    public void run() {
        buildTreePerson();
    }

    public void buildTreePerson(){
        PersonComparator personComparator = new PersonComparator();
        TreeSet<Person> persons = new TreeSet<>(personComparator);

        persons.add(new Person("Vasya", 30,30));
        persons.add(new Person("Petya", 40,30));

        for ( Person s: persons) {
            System.out.println(s);
        }
    }

    public void buildTreeStudent(){
        TreeSet<Student> students = new TreeSet<>();

        students.add(new Student("Vasya", 30,30));
        students.add(new Student("Petya", 30,30));

        for ( Student s: students) {
            System.out.println(s);
        }
    }



    public void startSortObj(){
        Student a = new Student("Vasya", 30,30);
        Student b = new Student("Petya", 30,40);

        if (a == b) { // Если ранее a = b // a == null
            System.out.println(" a == b ");
        }  else {
            System.out.println(" a != b  -  пойдет по этому пути");
        }

        /*
        if(a.compareTo(b) == 0) {
            System.out.println(" a == b  с точки зрения правил сравнения, описанных программистом");
        }

         */



        /*
        if (a > b) {
            System.out.println(" a > b ");
        }

        if (a == b) { // Если ранее a = b // a == null
            System.out.println(" a == b ");
        }  else {
            System.out.println(" a != b ");
        }

        if (a < b) {
            System.out.println(" a < b ");
        }
        */



    }




    public void buble() {
        int t;
        int[] r = new int[100];
        int N = r.length;

        Random rnd = new Random();

        for (int i = 0; i < N; i++){
            r[i] = rnd.nextInt();
        }


        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (r[j] < r[i]) {
                    t = r[i];
                    r[i] = r[j];
                    r[j] = t;
                }

    }
}
