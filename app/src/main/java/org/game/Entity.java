package org.game;

import java.util.Random;

public abstract class Entity {
    public String name;
    public int maxHp;
    public int hp;
    public int attackPower;
    public Weapon weapon;

    public abstract void takeDamage(int damage);
    public abstract void kill();
    public abstract String genWarcry();

    public void attack(Entity target) {
        System.out.println("You attempt to attack " + target.name + "...");
        Random rand = new Random();

        if (rand.nextDouble(1.0) <= weapon.missChance) {
            System.out.println("... and you miss.");
            return;
        }

        int damage = Math.max(weapon.minDamage, rand.nextInt(weapon.maxDamage));

        if (rand.nextDouble(1.0) <= weapon.critChance) {
            target.takeDamage(damage * 2);
            System.out.println(genWarcry());
            System.out.println("Critical hit! You hit " + target.name + " for " + damage * 2 + "damage.");
        } else {
            target.takeDamage(damage);
            System.out.println(genWarcry());
            System.out.println("You hit " + target.name + " for " + weapon.attackMessage + "damage.");
        }
    }

    public void heal(int hp) {
        if (this.hp + hp > maxHp) {
            this.hp = maxHp;

            return;
        }

        this.hp += hp;
    }
}
