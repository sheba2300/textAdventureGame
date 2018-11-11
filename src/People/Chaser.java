// Sheba Sow
package People;

import Rooms.MainRoom;

public class Chaser extends Characters
{
    //represents turkey contains their location, datatype, name and symbol that will be displayed on the board

    private String firstName, type;
    private int xLoc, yLoc;
    public Chaser (String firstName, int xLoc, int yLoc, String type)
    {
        super(firstName, xLoc,yLoc, type);
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.firstName = firstName;
        this.type = type;
    }

    public String getAction(Chaser x, MainRoom[][] y)
    {
        //generates a random action (north,south,east,west)
        String turkeyAction;
        int chance = 0;
        chance = (int) (Math.floor(Math.random() * 4))+1;
        if (chance == 1)
        {
            return "n";
        } else if (chance == 2)
        {
            return"e";

        } else if (chance == 3)
        {
            return"s";

        } else
            {return "w";

        }

    }
    public static boolean validMove(String move, Characters p, MainRoom[][] building) {
    // checks if turkey can move to the location that was randomly generated. if it cant its a free-be for the user to move
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if (p.getxLoc() > 0) {
                    return true;
                } else {
                    return false;
                }
            case "e":
                if (p.getyLoc() < building[p.getyLoc()].length - 1) {

                    return true;
                } else {
                    return false;
                }

            case "s":
                if (p.getxLoc() < building.length - 1) {

                    return true;
                } else {
                    return false;
                }

            case "w":
                if (p.getyLoc() > 0) {

                    return true;
                } else {
                    return false;
                }
            default:
                break;

        }
        return false;


    }
    public String toString()
    {
        return " ᕙ(`▽´)ᕗ ";
    }
}