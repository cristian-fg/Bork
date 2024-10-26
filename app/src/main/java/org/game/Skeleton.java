package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Skeleton extends Entity {
    public Skeleton(String name) {
        maxHp = 100;
        hp = maxHp;
        this.name = name;

        Random rand = new Random();
        switch (rand.nextInt(2)) {
            case 0:
                weapon = new Weapon(WeaponClass.TWO_HANDED_AXE);
                break;
            case 1:
                weapon = new Weapon(WeaponClass.ONE_HANDED_SWORD);
                break;
            case 2:
                weapon = new Weapon(WeaponClass.BOW);
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
        Game.slowPrint("Was that someone’s skeleton? You got nothing… obviously", 30);
    }

    @Override
    public String genWarcry() {
        return "*bone rattle* '" + weapon.attackMessage + "'";
    }
}
