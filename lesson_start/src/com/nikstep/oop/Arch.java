package com.nikstep.oop;

public class Arch extends Gamer {
    @Override
    public void doAttack() {
        super.doAttack();
        System.out.println(" Стрелок же будет атакавать еще и по своему");
    }
}
