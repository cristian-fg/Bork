package org.game;

import java.util.Random;

public class DungeonLayout {
    public final int mainRooms;
    public final int maxBranchRooms;
    public Room originRoom;
    public Room currentRoom;
    public ExtraRoom currentExtraRoom;
    public boolean inExtraRoom;

    public DungeonLayout(final int mainRooms, final int maxBranchRooms) {
        this.mainRooms = mainRooms;
        this.maxBranchRooms = maxBranchRooms;
        inExtraRoom = false;
    }

    public void init() {
        // recursively generates rooms and adjacent rooms to explore
        originRoom = new Room(null, 0, mainRooms - 1);
        currentRoom = originRoom;
        currentExtraRoom = null;
    }

    public void exploreExtraRoom() {
        if (currentRoom.adjacentRoom == null) {
            Game.slowPrint("There is no available extra room to explore here.", 30);
            return;
        }
        if (currentExtraRoom == null) {
            // idk
        } else {
            if (currentExtraRoom.nextRoom == null) {
                Game.slowPrint("There is no available extra room to explore here.", 30);
                return;
            }
        }

        if (inExtraRoom) {
            if (currentExtraRoom.nextRoom == null) {
                System.out.println("l;algjdsflgjdf;lgkdsfj;kdsj;dfj;dskjg;dslkgj;dsklgj");
            }
            currentExtraRoom = currentExtraRoom.nextRoom;
        } else {
            currentExtraRoom = currentRoom.adjacentRoom;
        }

        inExtraRoom = true;
        Game.slowPrint("You decide to explore the extra room you found.", 30);
    }

    public void rollBackExtraRoom() {
        if (currentExtraRoom.previousRoom == null) {
            currentExtraRoom = null;
            inExtraRoom = false;
            return;
        }

        currentExtraRoom = currentExtraRoom.previousRoom;
    }
}
