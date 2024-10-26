package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Witch extends Entity {
    public Witch() {
        maxHp = 125;
        hp = 125;

        Random rand = new Random();
        switch (rand.nextInt(2)) {
            case 0:
                weapon = new Weapon(WeaponClass.STAFF);
                break;
            case 1:
                weapon = new Weapon(WeaponClass.WAND);
                break;
            case 2:
                weapon = new Weapon(WeaponClass.DAGGER);
                break;
        }
    }

    @Override
    public void attack(Entity target) {
        Game.slowPrint(name + " tries to attack you...", 30);
        Random rand = new Random();

        if (rand.nextDouble(1.0) <= weapon.missChance) {
            Game.slowPrint("... but they miss.", 30);
            return;
        }

        int damage = rand.ints(weapon.minDamage, weapon.maxDamage).findFirst().getAsInt();

        if (rand.nextDouble(1.0) <= weapon.critChance) {
            target.takeDamage(damage * 2);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("Critical hit! " +  name + " hits you for " + damage * 2 + " damage.", 30);
        } else {
            target.takeDamage(damage);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint(name + " hits you for " + damage + " damage.", 30);
        }
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
    }

    @Override
    public void kill() {
        Game.slowPrint("Ew, she had a gigantic wart in her nose. You got nothing.", 30);
    }

    @Override
    public String genWarcry() {
        return "he he he '" + weapon.attackMessage + "'";
    }
}
