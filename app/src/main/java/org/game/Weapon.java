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
                attackMessage = "CUT";
                minDamage = 6;
                maxDamage = Math.max(6, gen.nextInt(8));
                critChance = 0.15;
                missChance = 0.0;
                break;
            case TWO_HANDED_MACE:
                attackMessage = "MEGA BONK";
                minDamage = 6;
                maxDamage = Math.max(6, gen.nextInt(8));
                critChance = 0.15;
                missChance = 0.0;
                break;
            case ONE_HANDED_SWORD:
                attackMessage = "CUT";
                minDamage = 3;
                maxDamage = Math.max(3, gen.nextInt(6));
                critChance = 0.25;
                missChance = 0.10;
                break;
            case ONE_HANDED_AXE:
                attackMessage = "CUT";
                minDamage = 4;
                maxDamage = Math.max(4, gen.nextInt(6));
                critChance = 0.25;
                missChance = 0.10;
                break;
            case DAGGER:
                attackMessage = "CUT";
                minDamage = 3;
                maxDamage = Math.max(3, gen.nextInt(6));
                critChance = 0.40;
                missChance = 0.10;
                break;
            case BOW:
                attackMessage = "SWOOP IDFK";
                minDamage = 4;
                maxDamage = Math.max(4, gen.nextInt(8));
                critChance = 0.40;
                missChance = 0.15;
                break;
            case STAFF:
                attackMessage = "MAGICAL NOISES";
                minDamage = 4;
                maxDamage = Math.max(4, gen.nextInt(8));
                critChance = 0.15;
                missChance = 0.8;
                break;
            case WAND:
                attackMessage = "MAGICAL NOISES";
                minDamage = 3;
                maxDamage = Math.max(3, gen.nextInt(6));
                critChance = 0.25;
                missChance = 0.8;
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
    }
}
