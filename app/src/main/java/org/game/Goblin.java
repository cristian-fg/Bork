package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class Goblin extends Entity {
    public Goblin(WeaponClass weaponClass) {
        maxHp = 80;
        hp = 80;

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
                //weapon = new Weapon(WeaponClass);
                break;
            case 5:
                //weapon = new Weapon(WeaponClass.lkfdjg);
                break;
        }

        weapon = new Weapon(weaponClass);
    }

    @Override
    public void attack(Entity target) {
        Game.slowPrint(target.name + " tries to attack you...", 30);
        Random rand = new Random();

        if (rand.nextDouble(1.0) <= weapon.missChance) {
            Game.slowPrint("... but they miss.", 30);
            return;
        }

        int damage = Math.max(weapon.minDamage, rand.nextInt(weapon.maxDamage));

        if (rand.nextDouble(1.0) <= weapon.critChance) {
            target.takeDamage(damage * 2);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("Critical hit! " +  target.name + " hits you for " + damage * 2 + " damage.", 30);
        } else {
            target.takeDamage(damage);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint(target.name + " hits you for " + damage + " damage.", 30);
        }
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
    }

    @Override
    public void kill() {
        Game.slowPrint("You killed a goblin. You get nothing.", 30);
    }

    @Override
    public String genWarcry() {
        return "*blurg*";
    }
}
