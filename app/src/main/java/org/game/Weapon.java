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
                maxDamage = gen.ints(54, 60).findFirst().getAsInt();
                critChance = 0.25;
                missChance = 0.15;
                break;
            case TWO_HANDED_MACE:
                attackMessage = "MEGA BONK";
                minDamage = 37;
                maxDamage = gen.ints(44, 60).findFirst().getAsInt();
                critChance = 0.30;
                missChance = 0.20;
                break;
            case ONE_HANDED_SWORD:
                attackMessage = "-Generic- SLASHHHH";
                minDamage = 32;
                maxDamage = gen.ints(40, 50).findFirst().getAsInt();
                critChance = 0.25;
                missChance = 0.10;
                break;
            case ONE_HANDED_AXE:
                attackMessage = "Ching Ching Chop";
                minDamage = 28;
                maxDamage = gen.ints(33, 50).findFirst().getAsInt();
                critChance = 0.35;
                missChance = 0.14;
                break;
            case DAGGER:
                attackMessage = "Shing shing... SHING";
                minDamage = 24;
                maxDamage = gen.ints(40, 52).findFirst().getAsInt();
                critChance = 0.68;
                missChance = 0.20;
                break;
            case BOW:
                attackMessage = "FIIIUUUuuummmm *TING*";
                minDamage = 35;
                maxDamage = gen.ints(37, 55).findFirst().getAsInt();
                critChance = 0.50;
                missChance = 0.30;
                break;
            case STAFF:
                attackMessage = "MAGICAL NOISES";
                minDamage = 5;
                maxDamage = gen.ints(30, 200).findFirst().getAsInt();
                critChance = 0.30;
                missChance = 0.10;
                break;
            case WAND:
                attackMessage = "Powerful spell in an ancient language is casted!";
                minDamage = 31;
                maxDamage = gen.ints(31, 40).findFirst().getAsInt();
                critChance = 0.10;
                missChance = 0.10;
                break;
            case GUN:
                attackMessage = "Welcome to the land of freedom (Eagle noises)";
                minDamage = 699990;
                maxDamage = gen.ints(699991, 100000000).findFirst().getAsInt();
                critChance = 0.90;
                missChance = 0.83;
                break;
            case LEGENDARY_ULTRA_POWERFUL_MIGHTY_SWORD:
                attackMessage = "GET OUT!!!!!!!!11!!111! (3 fire emojis)";
                minDamage = 2;
                maxDamage = gen.ints(3, 4).findFirst().getAsInt();
                critChance = 0.10;
                missChance = 0.0;
                break;
           case JOLLY_TEETHBREAKER:
                attackMessage = "Ho Ho Ho, Merry Christmas to you all!";
                minDamage = 40;
                maxDamage = gen.ints(41, 80).findFirst().getAsInt();
                critChance = 0.5;
                missChance = 0.5;
                break;
           case SPEAR:
                attackMessage = "Bazinga!!!!!";
                minDamage = 18;
                 maxDamage = gen.ints(63, 65).findFirst().getAsInt();
                critChance = 0.43;
                missChance = 0.20;
                break;
           case EIGON:
                attackMessage = "MORGANA- Wow, looking cool Joker!";
                minDamage = 30;
                 maxDamage = gen.ints(60, 70).findFirst().getAsInt();
                critChance = 0.33;
                missChance = 0.20;
                break;
            case MYRIAD_TRUTHS:
                attackMessage = "BY THE MYRIAD TRUTHS!!!";
                minDamage = 600;
                maxDamage = gen.ints(1000, 100000).findFirst().getAsInt();
                critChance = 0.33;
                missChance = 0.20;
                break;
            case GARU :
                attackMessage = "MORGANA- That is incredible, Joker!";
                minDamage = 40;
                maxDamage = gen.ints(50, 55).findFirst().getAsInt();
                critChance = 0.33;
                missChance = 0.37;
                break;
            case AGI :
                attackMessage = "ANN- Carmen, take em' down!";
                minDamage = 10;
                maxDamage = gen.ints(62, 80).findFirst().getAsInt();
                critChance = 0.62;
                missChance = 0.42;
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
        SPEAR,
        EIGON,
        MYRIAD_TRUTHS,
        GARU,
        AGI,

    }
}
