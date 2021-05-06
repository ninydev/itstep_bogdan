package com.nikstep.may06;
/**
 * Сущность Студент
 * -------------------------------------------------------------------------
 * Содержит поля, необходимые для хранения информации о студенте, в рамках
 * данной задачи
 * + Следует использовать
 */

public class Student  implements Comparable<Student>  {

    public int id;

    public String name;
    public int weight;
    public int height;

    public Student(String name, int w, int h) {
        this.name = name;
        this.weight = w;
        this.height = h;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }


    @Override
    public int compareTo(Student o) {
        if (this.weight < o.weight) return -1;
        if (this.weight > o.weight) return 1;
        return 0;
    }


    /*
    @Override
    public int compareTo(Integer o) {
        if (this.weight < o) return -1;
        if (this.weight > o) return 1;
        return 0;
    }

     */

    public int mySravnilka(Student o) {
        if (this.weight < o.weight) return -1;
        if (this.weight > o.weight) return 1;
        return 0;
    }
}

