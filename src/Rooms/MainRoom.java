// Sheba Sow
package Rooms;

import People.Person;
import People.Characters;

public class MainRoom implements Rooms{
    Characters[] occupant = new Characters[2];

        int xLoc,yLoc;

        public MainRoom(int x, int y)
        {
            xLoc = x;
            yLoc = y;
        }
        public Characters[] getOccupants()
        {
            return occupant;
        }
        /**
         * Method controls the results when a person enters this room.
         * @param x the Person entering
         */
        public void enterRoom(Characters x)
        {
            //gets an empty spot and sets that spot equal to the character that just entered
            for (int i = 0; i < occupant.length; i++) {
                if (occupant[i] == null || occupant[i] == x) {
                    x.setxLoc(this.xLoc);
                    x.setyLoc(this.yLoc);
                    occupant[i] = x;
                    return;
                }

            }
            return;
        }

        /**
         * Removes the player from the room.
         * @param x
         */
        public void leaveRoom(Characters x)
        {
            //finds character that wants to leave and take it out of that room/array
            for(int i =0; i< occupant.length; i++)
            {
                if(occupant[i] == x)
                occupant[i] = null;
            }
        }
        public static boolean found(Characters[] occupant)
        {
            /*checks to see if one room has two characters. since the two characters can only be a chaser and a person, this means
             that the user lost*/
            if((occupant[0] != null && occupant[1] != null)) {
                System.out.println("You were caught. Game over");
                return true;
            }
            return false;
        }
    public String toString()
    {   // if the chaser and person are in the same room both item in the occupant array will be !=null.
        // so it displays a game over face
        if((occupant[0] != null && occupant[1] != null)) {
            return "(҂◡_◡) ᕤ";

        }

        for(int x = 0; x<occupant.length;x++)
        {
            if(occupant[x]!= null)
                return occupant[x].toString();
        }
        return "  |    |  "; // any space that is not a character or winning room

    }
    }

