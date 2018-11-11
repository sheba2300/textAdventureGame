// Sheba Sow
package Rooms;
import People.Characters;

public interface Rooms {
    void enterRoom(Characters x);
    Characters[] getOccupants();
    void leaveRoom(Characters x);


}
