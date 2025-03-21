package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Outlaw extends Entity {
    public  Outlaw() {
        maxHp = 145;
        hp = maxHp;

        Random rand = new Random();
        switch (rand.nextInt(3)) {
            case 0:
                weapon = new Weapon(WeaponClass.DUAL_KNIVES);
                break;
            case 1:
                weapon = new Weapon(WeaponClass.RUDIMENTARY_PISTOL);
                break;
            case 2:
                weapon = new Weapon(WeaponClass.GRAPPLING_HOOK);
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
    public void takeDamage(int damage) {
        hp -= damage;
    }

    @Override
    public void kill() {
        Game.slowPrint("You died.", 30);
        Game.slowPrint("You have been sentenced to death.", 30);
    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int msgNum = rand.nextInt(3);
        switch (msgNum) {
            case 0:
                return " DIE! " + weapon.attackMessage + "'";
            case 1:
                return " EVERYTHING TO THE BAG! '" + weapon.attackMessage + "'";
            case 2:
                return " HANDS UP." + weapon.attackMessage + "'";
            case 3:
                return " Watch this." + weapon.attackMessage + "'";
        }

        return "DIE! '" + weapon.attackMessage + "'";
    }
}
   

