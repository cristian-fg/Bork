package org.game;

import java.util.Random;

import org.checkerframework.checker.units.qual.min;

public class Weapon {
    public int minDamage;
    public int maxDamage;
    public double critChance;
    public double missChance;
    public String attackMessage;
    public WeaponClass type;

    public Weapon(WeaponClass weaponClass) {
        Random gen = new Random();
        type = weaponClass;
        switch (weaponClass) {
            case TWO_HANDED_AXE:
                attackMessage = "Swoosh Choosh Chop!";
                minDamage = 50;
                maxDamage = gen.ints(50, 60).findFirst().getAsInt();
                critChance = 0.15;
                missChance = 0.0;
                break;
            case TWO_HANDED_MACE:
                attackMessage = "MEGA BONK";
                minDamage = 45;
                maxDamage = gen.ints(45, 60).findFirst().getAsInt();
                critChance = 0.15;
                missChance = 0.0;
                break;
            case ONE_HANDED_SWORD:
                attackMessage = "-Generic- CUT";
                minDamage = 30;
                maxDamage = gen.ints(30, 50).findFirst().getAsInt();
                critChance = 0.25;
                missChance = 0.10;
                break;
            case ONE_HANDED_AXE:
                attackMessage = "Ching Ching Chop";
                minDamage = 30;
                maxDamage = gen.ints(30, 50).findFirst().getAsInt();
                critChance = 0.25;
                missChance = 0.10;
                break;
            case DAGGER:
                attackMessage = "Shing shing... SHING";
                minDamage = 23;
                maxDamage = gen.ints(23, 45).findFirst().getAsInt();
                critChance = 0.40;
                missChance = 0.10;
                break;
            case BOW:
                attackMessage = "FIIIUUUuuummmm *TING*";
                minDamage = 30;
                maxDamage = gen.ints(30, 60).findFirst().getAsInt();
                critChance = 0.40;
                missChance = 0.20;
                break;
            case STAFF:
                attackMessage = "MAGICAL NOISES";
                minDamage = 30;
                maxDamage = gen.ints(40, 60).findFirst().getAsInt();
                critChance = 0.15;
                missChance = 0.15;
                break;
            case WAND:
                attackMessage = "Powerful spell in an ancient language is casted!";
                minDamage = 23;
                maxDamage = gen.ints(30, 50).findFirst().getAsInt();
                critChance = 0.25;
                missChance = 0.8;
                break;
            case GUN:
                attackMessage = "Welcome to the land of freedom (Eagle noises)";
                minDamage = 699990;
                maxDamage = gen.ints(699990, 100000000).findFirst().getAsInt();
                critChance = 0.9;
                missChance = 0.8;
                break;
            case LEGENDARY_ULTRA_POWERFUL_MIGHTY_SWORD:
                attackMessage = "GET OUT!!!!!!!!11!!111! (3 fire emojis)";
                minDamage = 1;
                maxDamage = gen.ints(1, 2).findFirst().getAsInt();
                critChance = 0.1;
                missChance = 0.0;
                break;
        }

    }

    public enum WeaponClass {
        TWO_HANDED_AXE,
        TWO_HANDED_MACE,
        ONE_HANDED_SWORD,
        ONE_HANDED_AXE,
        DAGGER,
        BOW,
        STAFF,
        WAND,
        GUN,
        LEGENDARY_ULTRA_POWERFUL_MIGHTY_SWORD;
    }
}
