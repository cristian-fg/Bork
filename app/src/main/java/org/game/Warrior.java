package org.game;

import java.util.Random;

public class Warrior extends Entity {
    private final int PASSIVE_ARMOUR = 2;

    public Warrior() {
        maxHp = 12;
        hp = 10;
        armour = 0;
        level = 1;
        attackPower = 0;
    }

    @Override
    public void takeDamage(int damage) {
        hp -= Math.max(0, (damage - armour - PASSIVE_ARMOUR));
        if (hp < 1) {
            kill();
        }
    }

    @Override
    public void kill() {
        System.out.println("you fucking died");
        System.exit(0);
    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int msgNum = rand.nextInt(2);
        switch (msgNum) {
            case 0:
                return "OOOOOOOAAAAAAUUUUUGGGGGGGHHHHH";
            case 1:
                return "GRRRROOOOOOOOOOAAAAAAAGGGGGHHHHHH";
            case 2:
                return "HUUUUUUOOOOOOOOAAAAAGGGGGHHHHHHH";
        }

        return "OOOOOOOAAAAAAUUUUUGGGGGGGHHHHH";
    }
}
