// Sheba Sow
package Rooms;
import People.Characters;
//interface for the person and chaser
public interface Rooms {
    void enterRoom(Characters x);
    Characters[] getOccupants();
    void leaveRoom(Characters x);


}
