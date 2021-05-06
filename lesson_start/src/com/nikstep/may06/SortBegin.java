package com.nikstep.may06;

import java.util.Random;

public class SortBegin implements Runnable {

    @Override
    public void run() {
        startSortObj();
    }


    public void startSortObj(){
        Student a = new Student("Vasya", 20,30);
        Student b = new Student("Petya", 30,40);

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
