package com.nikstep.entity;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Group {
    public int id;

    public String name;

    public LinkedList<Student> students = new LinkedList<>();

    public Group() {}

    public Group(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String res ="Group{" +  ", name='" + name + "\' }";
        if (students.size() == 0) return res;
        res+= "\n";
        for (Student s: students) {
            res+=" --> " + s + "\n";
        }
        return res;
    }

}
