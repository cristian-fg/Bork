package org.game;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        slowPrint("Choose your vessel...", 40);
        slowPrint("You can become a mighty warrior... a lone rogue... or a fearsome mage...", 40);
        slowPrint("What is your choice? Speak.", 40);

        Entity player = null;

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

        slowPrint("What is the name of this vessel?", 40);
        String name = input.nextLine();
        slowPrint("Hmm... What a delightful name.", 40);
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

        slowPrint("You awaken in a forest.");
        //player.attack();

        input.close();
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
}


