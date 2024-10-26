package org.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.game.Weapon.WeaponClass;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean gameRunning = true;


        while (gameRunning) {
            startScreen();
            Entity player = null;

            slowPrint("Choose your vessel...", 40);
            slowPrint("You can become a mighty warrior... a lone rogue... or a fearsome mage...", 40);
            slowPrint("What is your choice? Speak.", 40);
            boolean validClassChoice = false;
            while (!validClassChoice) {
                System.out.print("> ");
                String choice = input.nextLine();

                switch (choice.toLowerCase()) {
                    case "warrior":
                    player = new Warrior();
                    validClassChoice = true;
                    break;
                    case "mage":
                    player = new Mage();
                    validClassChoice = true;
                    break;
                    case "rogue":
                    player = new Rogue();
                    validClassChoice = true;
                    break;
                    default:
                    slowPrint("That is not a valid choice.", 40);
                    slowPrint("Choose between a 'warrior', a 'rogue', or a 'mage.'", 40);
                    System.out.println("(Please choose only between those 3 words)");
                    break;
                }
            }
            /*
            slowPrint("What is the name of this vessel?", 40);
            String name = input.nextLine();
            slowPrint("Hmm... What a delightful name.", 40);
            player.name = name;

            slowPrint("Now...", 40);
            slowPrint("You feel as if your vision is becoming blurry...", 40);
            slowPrint("And you faint.", 40);

            try {
                Thread.sleep(1500);
                clearConsole();
            } catch (InterruptedException e) {
                System.out.println("TOO BAD! DIE");
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("TOO BAD! DIE");
            }

            slowPrint("You awaken in a dark dungeon", 30);
            slowPrint("You need to get out of there.", 30);
            */

            Goblin gobling = new Goblin();
            gobling.name = "Jeff";
            Battle battle = new Battle(player, gobling);
            battle.battle();

            if (battle.playerLost) {
                continue;
            }

            slowPrint("congratulations you won or something idk");
            System.out.println();
            System.out.println("Input anything to go back to title screen.");
            System.out.print("> ");
            String wait = input.nextLine();
        }
    }

    public static void slowPrint(String msg) {
        for (int i = 0; i < msg.length(); i++) {
            System.out.print(msg.charAt(i));

            long targetTime = System.nanoTime() + 250 * 1_000_000L;
            while (System.nanoTime() < targetTime) {

            }
        }

        System.out.println();
    }

    public static void slowPrint(String msg, int speed) {
        for (int i = 0; i < msg.length(); i++) {
            System.out.print(msg.charAt(i));

            long targetTime = System.nanoTime() + speed * 1_000_000L;
            while (System.nanoTime() < targetTime) {

            }
        }
        System.out.println();
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void startScreen() {
        clearConsole();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("______  ___________ _   __");
        System.out.println("| ___ \\|  _  | ___ \\ | / /");
        System.out.println("| |_/ /| | | | |_/ / |/ /");
        System.out.println("| ___ \\| | | |    /|    \\");
        System.out.println("| |_/ /\\ \\_/ / |\\ \\| |\\  \\");
        System.out.println("\\____/  \\___/\\_| \\_\\_| \\_/");
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
        System.out.println("By:\nCristian Fumagal Galvan\nJuan Pablo Marcos Chapa\nMauricio Bejar\n");
        System.out.println("Input anything to start the game.");
        System.out.print("> ");

        String wait = scanner.nextLine();
        clearConsole();
    }

    public static void gameOver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println(" _____ _   _______ _      _       _____ _____ _____ _   _ _____ ");
        System.out.println("/  ___| | / /_   _| |    | |     |_   _/  ___/  ___| | | |  ___|");
        System.out.println("\\ `--.| |/ /  | | | |    | |       | | \\ `--.\\ `--.| | | | |__  ");
        System.out.println(" `--. \\    \\  | | | |    | |       | |  `--. \\`--. \\ | | |  __| ");
        System.out.println("/\\__/ / |\\  \\_| |_| |____| |____  _| |_/\\__/ /\\__/ / |_| | |___ ");
        System.out.println("\\____/\\_| \\_/\\___/\\_____/\\_____/  \\___/\\____/\\____/ \\___/\\____/ ");
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        System.out.println("As punishement you lose all of your progress and go back to the start.");
        System.out.println();
        System.out.println("Input anyting to progress.");
        System.out.print("> ");

        String wait = scanner.nextLine();
        clearConsole();
    }

    public static void waitForInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input anything to proceed.");
        System.out.print("> ");
        scanner.nextLine();
    }
}


