package org.game;

import java.util.Random;
import java.util.Scanner;

import org.game.Weapon.WeaponClass;

public class Game {
    public static DungeonLayout dungeon = new DungeonLayout(5, 2);

    public static void main(String[] args) {
        dungeon.init();
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean gameRunning = true;
        boolean lost = false;

        while (gameRunning) {
            startScreen();
            Entity player = null;

            slowPrint("Choose your vessel...", 20);
            slowPrint("You can become a mighty warrior... a lone rogue... a fearsome mage...", 20);
            slowPrint("Maybe even a skilled chef... or a legendary outlaw", 20);
            slowPrint("What is your choice? Speak.", 20);
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
                    case "chef":
                    player = new Chef();
                    validClassChoice = true;
                    break;
                    case "outlaw":
                    player = new Outlaw();
                    validClassChoice = true;
                    break;
                    default:
                    slowPrint("That is not a valid choice.", 40);
                    slowPrint("Choose an specific command, like: 'warrior', 'rogue' or even 'mage'.", 40);
                    System.out.println("(Please choose only between those 3 words)");
                    break;
                }
            }

            slowPrint("What is the name of this vessel?", 40);
            String name = input.nextLine();
            slowPrint("Hmm... What a delightful name. But irrelevant.", 40);
            player.name = name;

            if (player.name.equals("god")) {
                player.weapon = new Weapon(WeaponClass.GUN);
                slowPrint("May God Bless America...", 1);
            }
            if (player.name.equals("Trickster")) {
                player = new Joker();
                player.name = "Joker";
                slowPrint("I am thou, Thou art I...", 1);
            }

            slowPrint("Now...", 40);
            slowPrint("You feel as if your vision is becoming blurry...", 40);
            slowPrint("And you faint.", 40);

            try {
                Thread.sleep(1500);
                clearConsole();
            } catch (InterruptedException e) {
                System.out.println("Main thread crashed, UNLUCKY");
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Main thread crashed, UNLUCKY");
            }

            slowPrint("You awaken in a dark dungeon.", 30);
            slowPrint("Next to you, you find a " + player.weapon.type.name() + ".", 30);

            dungeon.inExtraRoom = false;
            while (!lost) {
                waitInRoom(player);
                if (!dungeon.inExtraRoom) {
                    if (!dungeon.currentRoom.battleDone) {
                        Battle battle = new Battle(player, dungeon.currentRoom.enemy);
                        battle.battle();
                        dungeon.currentRoom.battleDone = true;
                        if (battle.playerLost) {
                            lost = true;
                        }
                        if (battle.enemy.name.equals("∴╎ꖎꖎ ᓭℸ ̣ ∷⚍ᓵꖌ ||𝙹⚍ ∴╎ℸ ̣ ⍑ ") && !lost) {
                            break;
                        }
                    }
                } else {
                    if (!dungeon.currentExtraRoom.battleDone) {
                        Battle battle = new Battle(player, dungeon.currentExtraRoom.enemy);
                        battle.battle();
                        dungeon.currentExtraRoom.battleDone = true;
                        if (battle.playerLost) {
                            lost = true;
                        }
                    }
                }

            }

            if (lost) {
                continue;
            }

            System.out.println(" __   _____  _   _  __        _____ _   _ _ _ ");
            System.out.println(" \\ \\ / / _ \\| | | | \\ \\      / /_ _| \\ | | | | ");
            System.out.println(" \\ V / | | | | | |  \\ \\ /\\ / / | ||  \\| | | | ");
            System.out.println("   | || |_| | |_| |   \\ V  V /  | || |\\  |_|_|");
            System.out.println("   |_| \\___/ \\___/     \\_/\\_/  |___|_| \\_(_|_) ");
            /*
            waitInRoom(player);

            Goblin goblin = new Goblin("JEFF THE GOBLIN");
            Battle battle = new Battle(player, goblin);
            battle.battle();

            if (battle.playerLost) {
                continue;
            }

            waitInRoom(player);

            Witch witch = new Witch("Witch from Clash Royale");
            Battle battle2 = new Battle(player, witch);
            battle2.battle();

            if (battle2.playerLost) {
                continue;
            }

            waitInRoom(player);

            Skeleton skeleton = new Skeleton("sans undertale");
            Battle battle3 = new Battle(player, skeleton);
            battle3.battle();

            if (battle3.playerLost) {
                continue;
            }

            waitInRoom(player);

            DarkMage mage = new DarkMage("Dark Magician");
            Battle battle4 = new Battle(player, mage);
            battle4.battle();

            if (battle4.playerLost) {
                continue;
            }

            waitInRoom(player);

            SantaClaus santa = new SantaClaus();
            Battle battle5 = new Battle(player, santa);
            battle5.battle();

            if (battle5.playerLost) {
                continue;
            }

            waitInRoom(player);

            slowPrint("THIS IS THE FINAL BATTLE. HOW THE HELL ARE YOU HERE.");
            TheVoid boss = new TheVoid();
            Battle finalBattle = new Battle(player, boss);
            finalBattle.battle();

            if (finalBattle.playerLost) {
                System.out.println("UNLUCKY :)))))))");
                continue;
            }
            */

            slowPrint("congratulations you won or something idk. how");
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
        System.out.println("Input anything to start the game, or type 'exit' to close the game.");
        System.out.print("> ");

        String wait = scanner.nextLine();
        if (wait.equals("exit")) {
            System.out.println("Thanks for playing :thumbs_up:");
            System.exit(0);
        }
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

    public static void waitInRoom(Entity player) {
        Scanner scanner = new Scanner(System.in);
        if (dungeon.inExtraRoom) {
            if (dungeon.currentExtraRoom.nextRoom == null) {
                Game.slowPrint("There are no more additional rooms you can explore. You may only return now.", 30);
            }
        } else {
            Game.slowPrint("There is a metal door in front of you.", 30);
        }

        if (dungeon.inExtraRoom) {
            if (dungeon.currentExtraRoom.battleDone) {
                Game.slowPrint("You have already explored this room.", 30);
            }
            if (dungeon.currentExtraRoom.nextRoom != null) {
                Game.slowPrint("There is also another room you can explore.", 30);
            }
        } else if (dungeon.currentRoom.adjacentRoom != null) {
            Game.slowPrint("There is also another room you can explore.", 30);
        }
        Game.slowPrint("Before you proceed... Rest for a little bit and heal.", 30);
        player.healToMax();
        boolean proceed = false;
        while (!proceed) {
            Game.slowPrint("While you rest, you can check your status by writing: 'status'.", 30);
            if (!dungeon.inExtraRoom) {
                Game.slowPrint("If you wish to continue, write 'continue'.", 30);
            }
            if (!dungeon.inExtraRoom) {
                if (dungeon.currentRoom.adjacentRoom != null) {
                    Game.slowPrint("If you wish to explore the additional room, write 'explore'.", 30);
                }
            } else if (dungeon.inExtraRoom) {
                if (dungeon.currentExtraRoom.nextRoom != null) {
                    Game.slowPrint("If you wish to explore the additional room, write 'explore'.", 30);
                }
            }
            if (dungeon.inExtraRoom) {
                if (dungeon.currentExtraRoom.nextRoom != null) {
                    Game.slowPrint("There is also another room you can explore.", 30);
                }
            }
            if (dungeon.inExtraRoom) {
                Game.slowPrint("If you wish to return from this extra room, write 'return'.", 30);
            }
            System.out.print("> ");
            String choice = scanner.nextLine();
            if (choice.equals("status")) {
                player.getInfo();
            } else if (choice.equals("continue")) {
                Game.slowPrint("You feel like each time you enter through a door, you get closer to the exit.", 30);
                Game.slowPrint("You open the door and proceed to the next room.", 30);
                dungeon.currentRoom = dungeon.currentRoom.nextRoom;
                return;
            } else if (choice.equals("explore")) {
                if (dungeon.currentRoom.adjacentRoom != null || dungeon.currentExtraRoom.nextRoom != null) {
                    dungeon.exploreExtraRoom();
                    return;
                } else {
                    Game.slowPrint("There is no available room to explore.", 30);
                }
            } else if (choice.equals("return")) {
                if (dungeon.inExtraRoom) {
                    Game.slowPrint("You return from the extra room you're in.", 30);
                    dungeon.rollBackExtraRoom();
                    if (dungeon.inExtraRoom) {
                        Game.slowPrint("You are still in another extra room.", 30);
                    } else {
                        Game.slowPrint("You have now returned to the main rooms.", 30);
                    }
                }
            }
        }
    }
}









