package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class DarkMage extends Entity {
    public DarkMage(String name) {
        maxHp = 200;
        hp = 140;
        this.name = name;

        Random rand = new Random();
        switch (rand.nextInt(2)) {
            case 0:
                weapon = new Weapon(WeaponClass.STAFF);
                break;
            case 1:
                weapon = new Weapon(WeaponClass.WAND);
                break;


        }
    }

    @Override
    public void attack(Entity target) {
        Game.slowPrint(name + " Aims to defeat you", 30);
        Random rand = new Random();

        if (rand.nextDouble(1.0) <= weapon.missChance) {
            Game.slowPrint("...Unnatural causes make the spell miss.", 30);
            return;
        }

        int damage = rand.ints(weapon.minDamage, weapon.maxDamage).findFirst().getAsInt();

        if (rand.nextDouble(1.0) <= weapon.critChance) {
            target.takeDamage(damage * 2);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("Critical hit! " +  name + " curses you for " + damage * 2.5 + " damage.", 30);
        } else {
            target.takeDamage(damage);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint(name + " burns you for " + damage + " damage.", 30);
        }
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
    }

    @Override
    public void kill() {
        Game.slowPrint("How dare thou kill such an skillfull sorcerer?", 30);
        Game.slowPrint("Thyn actions will not be compensated in any way.", 30);
    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int funnyphrase = rand.nextInt(3);
        switch (funnyphrase){
            case 0:
                return "Flare of Punishment!" + weapon.attackMessage + "'";
            case 1:
                return "Dark Magic Attack!" + weapon.attackMessage + "'";
            case 2:
                return "Vague d'Extorsion!" + weapon.attackMessage + "'";
            case 3:
                return "YOU SHALL NOT PASS!" + weapon.attackMessage + "'";
        }

        return "YOU SHALL NOT PASS!";
    }
}
