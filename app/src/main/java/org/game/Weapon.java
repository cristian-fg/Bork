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
                maxDamage = gen.ints(51, 60).findFirst().getAsInt();
                critChance = 0.15;
                missChance = 0.0;
                break;
            case TWO_HANDED_MACE:
                attackMessage = "MEGA BONK";
                minDamage = 45;
                maxDamage = gen.ints(46, 60).findFirst().getAsInt();
                critChance = 0.15;
                missChance = 0.0;
                break;
            case ONE_HANDED_SWORD:
                attackMessage = "-Generic- CUT";
                minDamage = 30;
                maxDamage = gen.ints(31, 50).findFirst().getAsInt();
                critChance = 0.25;
                missChance = 0.10;
                break;
            case ONE_HANDED_AXE:
                attackMessage = "Ching Ching Chop";
                minDamage = 30;
                maxDamage = gen.ints(31, 50).findFirst().getAsInt();
                critChance = 0.25;
                missChance = 0.10;
                break;
            case DAGGER:
                attackMessage = "Shing shing... SHING";
                minDamage = 23;
                maxDamage = gen.ints(24, 45).findFirst().getAsInt();
                critChance = 0.40;
                missChance = 0.10;
                break;
            case BOW:
                attackMessage = "FIIIUUUuuummmm *TING*";
                minDamage = 30;
                maxDamage = gen.ints(31, 60).findFirst().getAsInt();
                critChance = 0.40;
                missChance = 0.20;
                break;
            case STAFF:
                attackMessage = "MAGICAL NOISES";
                minDamage = 30;
                maxDamage = gen.ints(31, 60).findFirst().getAsInt();
                critChance = 0.15;
                missChance = 0.15;
                break;
            case WAND:
                attackMessage = "Powerful spell in an ancient language is casted!";
                minDamage = 23;
                maxDamage = gen.ints(24, 50).findFirst().getAsInt();
                critChance = 0.25;
                missChance = 0.2;
                break;
            case GUN:
                attackMessage = "Welcome to the land of freedom (Eagle noises)";
                minDamage = 699990;
                maxDamage = gen.ints(699991, 100000000).findFirst().getAsInt();
                critChance = 0.9;
                missChance = 0.0;
                break;
            case LEGENDARY_ULTRA_POWERFUL_MIGHTY_SWORD:
                attackMessage = "GET OUT!!!!!!!!11!!111! (3 fire emojis)";
                minDamage = 2;
                maxDamage = gen.ints(3, 4).findFirst().getAsInt();
                critChance = 0.1;
                missChance = 0.0;
                break;
           case JOLLY_TEETHBREAKER:
                attackMessage = "Ho Ho Ho, Merry Christmas to you all!";
                minDamage = 40;
                maxDamage = gen.ints(41, 80).findFirst().getAsInt();
                critChance = 0.5;
                missChance = 0.5;
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
        LEGENDARY_ULTRA_POWERFUL_MIGHTY_SWORD,
        JOLLY_TEETHBREAKER,
    }
}
