package org.game;

import java.util.Random;
import java.util.Scanner;

public class Battle {
    public BattleTurn turn = BattleTurn.YOUR_TURN;
    public Entity player;
    public Entity enemy;

    public Battle(Entity player, Entity enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public enum BattleTurn {
        YOUR_TURN,
        ENEMY_TURN,
    }

    public void battle() {
        Random rand = new Random();
        Game.slowPrint("You encountered " + enemy.name + " and enter a battle.");
        while (player.hp > 0 && enemy.hp > 0) {
            if (turn == BattleTurn.YOUR_TURN) {
                Game.slowPrint("Choose. 'attack', 'heal', or 'run'.", 30);
                switch (getPlayerChoice()) {
                    case ATTACK:
                        player.attack(enemy);
                        break;
                    case HEAL:
                        int healAmount = Math.max(40, rand.nextInt(60));
                        player.heal(healAmount);
                        Game.slowPrint("You healed for " + healAmount + " hp.", 30);
                        break;
                    case RUN_AWAY:
                        Game.slowPrint("You attempt to run away, but you trip and fall on your chin very embarrasingly.", 30);
                        break;
                }
            } else {
                enemy.attack(player);
            }
        }
    }

    public Action getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "attack":
                return Action.ATTACK;
            case "heal":
                return Action.HEAL;
            case "run":
                return Action.RUN_AWAY;
            default:
                return Action.ATTACK;
        }
    }

    public enum Action {
        ATTACK,
        HEAL,
        RUN_AWAY
    }
}
