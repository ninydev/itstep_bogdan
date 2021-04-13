package com.nikstep.oop;

public class Dragon extends Gamer implements IFly{
    @Override
    public void doAttack() {
        System.out.println(" Дракон еще и огнем бьет");
    }


    @Override
    public void doFly() {
        System.out.println(" Дракон умеет летать ");
    }
}
