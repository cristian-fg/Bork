package org.game;

public class Goblin extends Entity {
    @Override
    public void takeDamage(int damage) {
        if (hp - damage < 1) {
            kill();
            return;
        }

        hp -= damage;
        Game.slowPrint("You take " + damage + " damage.");
    }

    @Override
    public void kill() {
        Game.slowPrint("You killed a goblin. You get nothing.");
    }
    @Override
    public String genWarcry() {
        return "*blurg*";
    }
}
