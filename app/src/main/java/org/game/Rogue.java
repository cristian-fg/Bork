package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Rogue extends Entity {
    public Rogue(WeaponClass weaponClass) {
        maxHp = 90;
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
            Game.slowPrint("Critical hit! You hit " + target.name + " for " + damage * 2 + "damage.", 30);
        } else {
            target.takeDamage(damage);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("You hit " + target.name + " for " + damage + " damage.", 30);
        }
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 1) {
            kill();
        }
    }

    @Override
    public void kill() {
        Game.slowPrint("You died.", 30);
        Game.slowPrint("This is as far as you go...", 30);
    }

    @Override
    public String genWarcry() {
        return "...";

    }
}
