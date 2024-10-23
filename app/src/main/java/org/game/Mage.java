package org.game;

import java.util.Random;

public class Mage extends Entity {
  @Override
    public void kill() {
    System.out.println(" Magic is not the easy mode here man, game's over");
    System.exit(0);
    }

    @Override
    public String genWarcry() {
        Random rand = new Random();
        int msgNum = rand.nextInt(3);
        switch (msgNum) {
            case 0:
                return "IGNIS!";
            case 1:
                return "HUZZAHH!";
            case 2:
                return "abracadabra ";
            case 3:
                return "PK Fire";
        }

        return "IGNIS!";
    }
}
