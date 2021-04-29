package com.nikstep.entity;
/**
 * Сущность Студент
 * -------------------------------------------------------------------------
 * Содержит поля, необходимые для хранения информации о студенте, в рамках
 * данной задачи
 * + Следует использовать
 */

public class Student {

    public int id;

    public String name;
    public int weight;
    public int height;

    public Student(String name, int w, int h) {
        this.name = name; this.weight = w; this.height = h;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
