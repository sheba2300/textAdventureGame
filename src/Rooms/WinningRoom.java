// Sheba Sow
package Rooms;
import Game.Runner;
import People.Person;
import People.Chaser;
import People.Characters;
import Game.Runner;
public class WinningRoom extends MainRoom
{
    private int xLoc,yLoc;
    public WinningRoom(int x, int y) {
        super(x,y);
    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */

    public void enterRoom(Characters x) {
        for (int i = 0; i < occupant.length; i++) {
            if (occupant[i] == null || occupant[i] == x) {
                x.setxLoc(this.xLoc);
                x.setyLoc(this.yLoc);
                occupant[i] = x;
            }

        }
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You you made it out the forest, Congrats!");
        Runner.gameOff();
        Runner.makeExpert();
        Runner.checkPlaying();
    }

    public String toString()
    {
        return "  |★★★|";
    }
}