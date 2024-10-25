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
        Game.slowPrint("You encountered " + enemy.name + " and enter a battle.", 30);
        System.out.println(); // white space
        while (player.hp > 0 && enemy.hp > 0) {
            if (turn == BattleTurn.YOUR_TURN) {
                Game.slowPrint("--- YOUR TURN ---", 30);
                Game.slowPrint("Choose. 'attack', 'heal', or 'run'.", 30);
                switch (getPlayerChoice()) {
                    case ATTACK:
                        player.attack(enemy);
                        break;
                    case HEAL:
                        int healAmount = Math.max(40, rand.nextInt(60));
                        player.heal(healAmount);
                        break;
                    case RUN_AWAY:
                        Game.slowPrint("You attempt to run away, but you trip and fall on your chin very embarrasingly.", 30);
                        break;
                }

                if (enemy.hp < 1) {
                    System.out.println("You won! You get to live and progress to the next room");
                    break;
                }
                Game.slowPrint("-----------------", 30);
                System.out.println();
                turn = BattleTurn.ENEMY_TURN;
            } else {
                Game.slowPrint("--- ENEMY TURN ---", 30);
                enemy.attack(player);
                Game.slowPrint("-----------------", 30);
                System.out.println();
                turn = BattleTurn.YOUR_TURN;
            }
        }

        if (player.hp < 1) {
            player.kill();
            Game.slowPrint("BATTLE ENDED", 30);
            Game.slowPrint("-----------------", 30);

            Game.gameOver();
            return;
        }

        if (enemy.hp < 1) {
            enemy.kill();
            Game.slowPrint("BATTLE ENDED", 30);
            Game.slowPrint("-----------------", 30);
            return;
        }
    }

    public Action getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "attack":
                    return Action.ATTACK;
                case "heal":
                    return Action.HEAL;
                case "run":
                    return Action.RUN_AWAY;
                default:
                    Game.slowPrint("Invalid choice. Choose between 'attack', 'heal', or 'run'.", 30);
            }
        }
    }

    public enum Action {
        ATTACK,
        HEAL,
        RUN_AWAY
    }
}
