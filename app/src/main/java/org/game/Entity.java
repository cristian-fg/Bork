package org.game;

import java.util.Random;

public abstract class Entity {
    public String name;
    public int maxHp;
    public int hp;
    public Weapon weapon;

    public abstract void takeDamage(int damage);
    public abstract void kill();
    public abstract String genWarcry();
    public abstract void attack(Entity target);

    public void heal(int hp) {
        if (this.hp + hp > maxHp) {
            this.hp = maxHp;

            return;
        }

        this.hp += hp;
        Game.slowPrint("You take a health potion and heal for " + hp + " hp.", 30);
    }

    // only for player
    public void healToMax() {
        hp = maxHp;
        Game.slowPrint("You take a small rest and heal to maximum health.", 30);
    }

    public void getInfo() {
        Game.slowPrint("INFO : HP " + maxHp + "/" + hp + " | WEAPON: " + weapon.type.name(), 30);
    }
}
