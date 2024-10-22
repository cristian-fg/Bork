package org.game;

import java.util.Random;

public class Mage extends Entity {

    @Override
    public void takeDamage(int damage) {

    }

    @Override
    public void kill() {

    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int msgNum = rand.nextInt(2);
        switch (msgNum) {
            case 0:
                return "IGNIS!";
            case 1:
                return "HUZZAHH!";
            case 2:
                return "abracadabra bitch";
        }

        return "IGNIS!";
    }
}
