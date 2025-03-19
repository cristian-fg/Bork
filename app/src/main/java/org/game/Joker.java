package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Joker extends Entity {
    public Joker() {
        maxHp = 150;
        hp = maxHp;

        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                weapon = new Weapon(WeaponClass.EIGON);
                break;
            case 1:
                weapon = new Weapon(WeaponClass.MYRIAD_TRUTHS);
                break;
            case 2:
                weapon = new Weapon(WeaponClass.GARU);
                break;
            case 3:
                weapon = new Weapon(WeaponClass.AGI);
        }
    }

    @Override
    public void attack(Entity target) {
        Game.slowPrint("FUTABA- Joker is looking after " + target.name + "...-", 30);
        Random rand = new Random();

        if (rand.nextDouble(1.0) <= weapon.missChance) {
            Game.slowPrint("FUTABA- A miss! Joker you gotta aim!", 30);
            return;
        }

        int damage = rand.ints(weapon.minDamage, weapon.maxDamage).findFirst().getAsInt();

        if (rand.nextDouble(1.0) <= weapon.critChance) {
            target.takeDamage(damage * 2);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("RYUGI- Joker got one down " + target.name + " for " + damage * 2 + " damage!", 30);
        } else {
            target.takeDamage(damage);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("YUSEKE- Joker got the shadow " + target.name + " for " + damage + "! ", 30);
        }
    }
    @Override
    public void kill() {
        Game.slowPrint("IGOR -What a truly foolish end...-", 30);
    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int msgNum = rand.nextInt(3);
        switch (msgNum) {
            case 0:
                return " HARU- This is going to be graceful! '" + weapon.attackMessage + "'";
            case 1:
                return " MAKOTO- Get them down Joker!" + weapon.attackMessage + "'";
            case 2:
                return " AKECHI- Guess you are good for something..." + weapon.attackMessage + "'";
            case 3:
                return " PERSONA!!!!" + weapon.attackMessage + "'";
        }

        return "PERSONA!!!!" + weapon.attackMessage + "'";
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
    }
}

