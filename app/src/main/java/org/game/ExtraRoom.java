
package org.game;

public class ExtraRoom {
    public final Room originRoom;
    public final ExtraRoom previousRoom;
    public final ExtraRoom nextRoom;
    public Entity enemy;
    public boolean battleDone;

    public ExtraRoom(Room originRoom, ExtraRoom previousRoom, int missingAdjacentRooms) {
        System.out.println("Generating extra room... Remaining rooms: " + missingAdjacentRooms);
        this.originRoom = originRoom;
        this.previousRoom = previousRoom;
        battleDone = false;
        enemy = Room.randEntity();

        if (missingAdjacentRooms == 0) {
            nextRoom = null;
            return;
        } else {
            nextRoom = new ExtraRoom(originRoom, this, missingAdjacentRooms - 1);
        }
    }
}
