package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Warrior extends Entity {
    private final int PASSIVE_ARMOUR = 2;

    public Warrior() {
        maxHp = 12;
        hp = 10;
        attackPower = 0;

        Random rand = new Random();
        switch (rand.nextInt(5)) {
            case 0:
                weapon = new Weapon(WeaponClass.TWO_HANDED_AXE);
                break;
            case 1:
                weapon = new Weapon(WeaponClass.TWO_HANDED_MACE);
                break;
            case 2:
                weapon = new Weapon(WeaponClass.ONE_HANDED_AXE);
                break;
            case 3:
                weapon = new Weapon(WeaponClass.ONE_HANDED_SWORD);
                break;
            case 4:
                //weapon = new Weapon(WeaponClass.GUN);
                break;
            case 5:
                //weapon = new Weapon(WeaponClass.lkfdjg);
                break;
        }
    }

    @Override
    public void takeDamage(int damage) {
        hp -= Math.max(0, (damage - PASSIVE_ARMOUR));
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
