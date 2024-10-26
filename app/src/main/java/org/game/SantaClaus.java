package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class SantaClaus extends Entity {
    public SantaClaus() {
        maxHp = 500;
        hp = 500;
        name = "Santa Claus";

        Random rand = new Random();
        switch (rand.nextInt(2)) {
            case 0:
                weapon = new Weapon(WeaponClass.GUN);
                break;
            case 1:
                weapon = new Weapon(WeaponClass.LEGENDARY_ULTRA_POWERFUL_MIGHTY_SWORD);
                break;
            case 2:
                weapon = new Weapon(WeaponClass.JOLLY_TEETHBREAKER);
                break;
        }
    }

    @Override
    public void attack(Entity target) {
        Game.slowPrint(name + " Searchs for something in his bag...", 30);
        Random rand = new Random();

        if (rand.nextDouble(1.0) <= weapon.missChance) {
            Game.slowPrint(" But it was coal.", 30);
            return;
        }

        int damage = rand.ints(weapon.minDamage, weapon.maxDamage).findFirst().getAsInt();

        if (rand.nextDouble(1.0) <= weapon.critChance) {
            target.takeDamage(damage * 2);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("Critical hit! " +  name + " surprises you with " + damage * 2 + " damage.", 30);
        } else {
            target.takeDamage(damage);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint(name + " goes down the chimmney for " + damage + " damage.", 30);
        }
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
    }

    @Override
    public void kill() {
        Game.slowPrint("Great, christmas over. No present for you!", 30);
    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int funnyphrase = rand.nextInt(3);
        switch (funnyphrase){
            case 0:
                return "Ho Ho Ho, there it goes!" + weapon.attackMessage + "'";
            case 1:
                return "Where's Rudolph when I need him?!" + weapon.attackMessage + "'";
            case 2:
                return "Where the cookies?" + weapon.attackMessage + "'";
            case 3:
                return "You're heading the mischievous list!" + weapon.attackMessage + "'";
        }

        return "You're heading the mischievous list!";
    }
}
