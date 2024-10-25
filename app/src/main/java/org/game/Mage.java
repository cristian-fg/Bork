package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Mage extends Entity {
    public Mage(WeaponClass weaponClass) {
        maxHp = 100;
        hp = maxHp;
    }

    @Override
    public void attack(Entity target) {
        Game.slowPrint("You attempt to attack " + target.name + "...", 30);
        Random rand = new Random();

        if (rand.nextDouble(1.0) <= weapon.missChance) {
            Game.slowPrint("... and you miss.", 30);
            return;
        }

        int damage = Math.max(weapon.minDamage, rand.nextInt(weapon.maxDamage));

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
                return "IGNIS!";
            case 1:
                return "HUZZAHH!";
            case 2:
                return "abracadabra ";
            case 3:
                return "PK Fire";
        }

        return "IGNIS!";
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 1) {
            kill();
        }
    }
}
