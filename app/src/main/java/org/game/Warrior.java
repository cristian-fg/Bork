package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Warrior extends Entity {
    private final int PASSIVE_ARMOUR = 10;

    public Warrior() {
        maxHp = 130;
        hp = maxHp;

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
                weapon = new Weapon(WeaponClass.GUN);
                break;
            case 5:
                weapon = new Weapon(WeaponClass.LEGENDARY_ULTRA_POWERFUL_MIGHTY_SWORD);
                break;
        }
    }

    @Override
    public void attack(Entity target) {
        Game.slowPrint("You attempt to attack " + target.name + "...", 30);
        Random rand = new Random();

        if (rand.nextDouble(1.0) <= weapon.missChance) {
            Game.slowPrint("... and you miss.", 30);
            return;
        }

        int damage = rand.ints(weapon.minDamage, weapon.maxDamage).findFirst().getAsInt();

        if (rand.nextDouble(1.0) <= weapon.critChance) {
            target.takeDamage(damage * 2);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("Critical hit! You hit " + target.name + " for " + damage * 2 + " damage.", 30);
        } else {
            target.takeDamage(damage);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("You hit " + target.name + " for " + damage + " damage.", 30);
        }
    }

    @Override
    public void takeDamage(int damage) {
        hp -= Math.max(0, (damage-  PASSIVE_ARMOUR));
    }

    @Override
    public void kill() {
        Game.slowPrint("You died.", 30);
        Game.slowPrint("It seems brute force wasn't enough this time...", 30);
    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int msgNum = rand.nextInt(2);
        switch (msgNum) {
            case 0:
                return "OOOOOOOAAAAAAUUUUUGGGGGGGHHHHH '" + weapon.attackMessage + "'";
            case 1:
                return "GRRRROOOOOOOOOOAAAAAAAGGGGGHHHHHH '" + weapon.attackMessage + "'";
            case 2:
                return "HUUUUUUOOOOOOOOAAAAAGGGGGHHHHHHH '" + weapon.attackMessage + "'";
        }

        return "OOOOOOOAAAAAAUUUUUGGGGGGGHHHHH '" + weapon.attackMessage + "'";
    }
}
