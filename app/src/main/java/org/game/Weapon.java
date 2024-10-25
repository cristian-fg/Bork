package org.game;

import java.util.Random;

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
                maxDamage = Math.max(50, gen.nextInt(60));
                critChance = 0.15;
                missChance = 0.0;
                break;
            case TWO_HANDED_MACE:
                attackMessage = "MEGA BONK";
                minDamage = 45;
                maxDamage = Math.max(45, gen.nextInt(60));
                critChance = 0.15;
                missChance = 0.0;
                break;
            case ONE_HANDED_SWORD:
                attackMessage = "-Generic- CUT";
                minDamage = 23;
                maxDamage = Math.max(23, gen.nextInt(45));
                critChance = 0.25;
                missChance = 0.10;
                break;
            case ONE_HANDED_AXE:
                attackMessage = "Ching Ching Chop";
                minDamage = 30;
                maxDamage = Math.max(30, gen.nextInt(45));
                critChance = 0.25;
                missChance = 0.10;
                break;
            case DAGGER:
                attackMessage = "Shing shing... SHING";
                minDamage = 23;
                maxDamage = Math.max(23, gen.nextInt(45));
                critChance = 0.40;
                missChance = 0.10;
                break;
            case BOW:
                attackMessage = "FIIIUUUuuummmm *TING*";
                minDamage = 30;
                maxDamage = Math.max(30, gen.nextInt(60));
                critChance = 0.40;
                missChance = 0.15;
                break;
            case STAFF:
                attackMessage = "MAGICAL NOISES";
                minDamage = 30;
                maxDamage = Math.max(30, gen.nextInt(60));
                critChance = 0.15;
                missChance = 0.8;
                break;
            case WAND:
                attackMessage = "Powerful spell in an ancient language is casted!";
                minDamage = 23;
                maxDamage = Math.max(23, gen.nextInt(45));
                critChance = 0.25;
                missChance = 0.8;
                break;
            case GUN:
            attackMessage = "Welcome to the land of freedom (Eagle noises)";
            minDamage = 699990;
            maxDamage = Math.max(699990 ,gen.nextInt(100000000));
            critChance = 0.9;
            missChance = 0.8;
            break;

            case LEGENDARY_ULTRA_POWERFUL_MIGHTY_SWORD:
            attackMessage = "GET OUT!!!!!!!!11!!111! (3 fire emojis)";
            minDamage = 1;
            maxDamage = Math.max(1 ,gen.nextInt(2));
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
