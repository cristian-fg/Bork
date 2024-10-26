package org.game;

import java.util.Random;

import org.game.Weapon.WeaponClass;

public class TheVoid extends Entity {
    public TheVoid() {
        maxHp = 1000;
        hp = 1000;
        name = "∴╎ꖎꖎ ᓭℸ ̣ ∷⚍ᓵꖌ ||𝙹⚍ ∴╎ℸ ̣ ⍑ ";

        Random rand = new Random();
        switch (rand.nextInt(7)) {
            case 0:
                weapon = new Weapon(WeaponClass.TWO_HANDED_AXE);
                break;
            case 1:
                weapon = new Weapon(WeaponClass.TWO_HANDED_MACE);
                break;
            case 2:
                weapon = new Weapon(WeaponClass.ONE_HANDED_SWORD);
                break;
            case 3:
                weapon = new Weapon(WeaponClass.ONE_HANDED_AXE);
                break;
            case 4:
                weapon = new Weapon(WeaponClass.DAGGER);
                break;
            case 5:
                weapon = new Weapon(WeaponClass.BOW);
                break;
            case 6:
                weapon = new Weapon(WeaponClass.STAFF);
                break;
            case 7:
                weapon = new Weapon(WeaponClass.WAND);
                break;
        }
    }

    @Override
    public void attack(Entity target) {
        Game.slowPrint(name + " ᔑリᔑꖎ||ᓭᒷᓭ ℸ ̣ ⍑ᒷ 𝙹!¡ℸ ̣ ╎ᒲᔑꖎ ∴ᔑ|| ℸ ̣ 𝙹 ↸ᒷᓭℸ ̣ ∷𝙹|| ||𝙹⚍...", 30);
        Random rand = new Random();

        if (rand.nextDouble(1.0) <= weapon.missChance) {
            Game.slowPrint("⚍リ╎⍊ᒷ∷ᓭᒷ ╎ᓭ リ𝙹ℸ ̣  ᓵ𝙹𝙹!¡ᒷ∷ᔑℸ ̣ ╎リ⊣ ∴╎ℸ ̣ ⍑ ℸ ̣ ⍑ᒷ ᓵᔑ⚍ᓭᒷ", 30);
            return;
        }

        int damage = rand.ints(weapon.minDamage, weapon.maxDamage).findFirst().getAsInt();

        if (rand.nextDouble(1.0) <= weapon.critChance) {
            target.takeDamage(damage * 2);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint("ᓵ∷╎ℸ ̣ ╎ᓵᔑꖎ ⍑╎ℸ ̣ " +  name + " ∴╎ꖎꖎ ↸ᒷᒲᔑℸ ̣ ᒷ∷╎ᔑꖎ╎⨅ᒷ ||𝙹⚍ ∴╎ℸ ̣ ⍑ " + damage * 2 + " ↸ᔑᒲᔑ⊣ᒷ.", 30);
        } else {
            target.takeDamage(damage);
            Game.slowPrint(genWarcry(), 30);
            Game.slowPrint(name + " ∴╎ꖎꖎ ᓭℸ ̣ ∷⚍ᓵꖌ ||𝙹⚍ ∴╎ℸ ̣ ⍑ " + damage + " ↸ᔑᒲᔑ⊣ᒷ.", 30);
        }
    }

    @Override
    public void takeDamage(int damage) {
        hp -= damage;
    }

    @Override
    public void kill() {
        System.out.println("__   __              _    _ _         _   ");
        System.out.println("\\ \\ / /           | |  | (_)     | | ");
        System.out.println("\\ V /___  _   _  | |  | |_ _ __ | | ");
        System.out.println(" _____                  _____                      _   _     _  ");
        System.out.println(" _____                  _____                      _   _     _  ");
        System.out.println(" _____                  _____                      _   _     _  ");
        System.out.println(" _____                  _____                      _   _     _  ");
        System.out.println(" _____                  _____                      _   _     _  ");
        Game.slowPrint("Darkness is sealed, the kingdom is safe! ", 30);
    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int funnyphrase = rand.nextInt(3);
        switch (funnyphrase){
            case 0:
                return "C𝙹ᒲ!¡sᓵ╎ ╎ᓭ ℸ ̣ ⍑ᒷ ʖᒷᓭℸ ̣  ᓵꖎᔑᓭᓭ" + weapon.attackMessage + "'";
            case 1:
                return "ᒷリ↸ ╎ᓭ リᒷᔑ∷" + weapon.attackMessage + "'";
            case 2:
                return "ᒲᔑ↸ᒷ ʖ|| ᓵ∷╎ᓭℸ ̣ ╎ᔑリ ⋮⚍ᔑリ!¡╎ ᔑリ↸ ᒲᔑ⚍" + weapon.attackMessage + "'";
            case 3:
                return "リᒷ⍊ᒷ∷ ⊣╎⍊ᒷ ⚍!¡, ℸ ̣ ∷⚍ᓭℸ ̣  ||𝙹⚍∷ ╎リᓭℸ ̣ ╎リᓵℸ ̣ ᓭ" + weapon.attackMessage + "'";
        }

        return "リᒷ⍊ᒷ∷ ⊣╎⍊ᒷ ⚍!¡, ℸ ̣ ∷⚍ᓭℸ ̣  ||𝙹⚍∷ ╎リᓭℸ ̣ ╎リᓵℸ ̣ ᓭ";
    }
}
