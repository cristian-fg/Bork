package org.game;

import java.util.Random;

public class Room {
    public final Room originRoom;
    public final Room nextRoom;
    public boolean battleDone;
    public ExtraRoom adjacentRoom;
    public final Entity enemy;

    public Room(Room originRoom, int branchRooms, int remainingRooms) {
        System.out.println("Generating room... Remaining rooms: " + remainingRooms);
        this.originRoom = originRoom;
        if (Game.dungeon.maxBranchRooms - 1 == remainingRooms || remainingRooms == 0) {
            adjacentRoom = new ExtraRoom(this, null, 0);
        } else {
            adjacentRoom = new ExtraRoom(this, null, genExtraRoomsAmount(Game.dungeon.maxBranchRooms));
        }
        battleDone = false;

        if (originRoom == null) {
            adjacentRoom = null;
        }
        if (remainingRooms == 0) {
            nextRoom = null;
            enemy = new TheVoid();
            return;
        }

        enemy = Room.randEntity();
        nextRoom = new Room(this, genExtraRoomsAmount(Game.dungeon.maxBranchRooms), remainingRooms - 1);
    }

    public static int genExtraRoomsAmount(int maxBranchRooms) {
        if (maxBranchRooms == 1) {
            System.out.println("ERROR:");
            System.out.println("maxBranchRooms cannot be equal to 1\nfunction genExtraRoomsAmount()");
            System.exit(1);
        }

        Random gen = new Random();
        if (gen.ints(1, 3).findFirst().getAsInt() == 3) {
            return gen.ints(1, maxBranchRooms).findFirst().getAsInt();
        } else {
            return 0;
        }
    }

    public static Entity randEntity() {
        Random gen = new Random();
        switch (gen.ints(1, 5).findFirst().getAsInt()) {
            case 1:
                return new Goblin("JEFF THE GOBLIN OR SOMEBODY FROM HIS FAMILY");
            case 2:
                return new DarkMage("Dark Magician");
            case 3:
                return new Skeleton("Sans Undertale with a bow and arrow");
            case 4:
                return new SantaClaus();
            case 5:
                return new Witch("Witch from Clash of Clans");
            default:
                return new Goblin("JEFF THE GOBLIN OR SOMEBODY FROM HIS FAMILY");
        }
    }

}
