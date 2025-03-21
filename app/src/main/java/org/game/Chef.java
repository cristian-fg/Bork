package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Chef extends Entity {
    public Chef() {
        maxHp = 110;
        hp = maxHp;

        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                weapon = new Weapon(WeaponClass.GIGANTIC_SPATULA);
                break;
            case 1:
                weapon = new Weapon(WeaponClass.SALT_CANNON);
                break;
            case 2:
                weapon = new Weapon(WeaponClass.BOILING_POT);
                break;
            case 3:
                weapon = new Weapon(WeaponClass.GUN);
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
    public void kill() {
        Game.slowPrint("Magic is not the easy mode here man, game's over", 30);
    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int msgNum = rand.nextInt(3);
        switch (msgNum) {
            case 0:
                return " Pizza Time! '" + weapon.attackMessage + "'";
            case 1:
                return " 30 minutes or free!" + weapon.attackMessage + "'";
            case 2:
                return " Here's your dessert!" + weapon.attackMessage + "'";
            case 3:
                return " This one's on the house." + weapon.attackMessage + "'";
        }

        return " Pizza Time!" + weapon.attackMessage + "'";
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
    }
}
