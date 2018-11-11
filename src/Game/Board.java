// Sheba Sow
package Game;
import Rooms.MainRoom;
import Rooms.Rooms;
public class Board extends java.lang.Object
{

    private Rooms[][] finalBoard;
    //string equivalent to the mainRoom
    private String[][] pattern = new String[5][5];
    //passing room from the runner into the board class so it can be converted into a string
    public Board(MainRoom[][] x)
    {
        finalBoard = x;
    }



    @Override
    public String toString()
{
    //builds single string format to look like a board getting the symbols from each character/room
    String finalBoardDisplay = "";
    for(int x = 0; x < finalBoard.length; x++)
    {
        for(int i = 0; i <finalBoard[x].length; i++)
        {
            finalBoardDisplay += finalBoard[x][i].toString();
        }
        finalBoardDisplay += "\n";
    }
    return finalBoardDisplay;
}


    public void edit(String replace, int row, int column)
    {
        pattern[row][column] = replace;
    }

    public void fill (String filler)
    {
        //makes every thing the same symbol
        for(int x = 0; x < pattern.length;x++)
         {
            for( int i =0; i<pattern[x].length;i++)
             {
                 pattern[x][i] = filler;
             }
        }
    }
}