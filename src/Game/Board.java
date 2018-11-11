// Sheba Sow
package Game;
import Rooms.MainRoom;
import Rooms.Rooms;
public class Board extends java.lang.Object
{

    private Rooms[][] finalBoard;
    private String[][] pattern = new String[5][5];

    public Board(MainRoom[][] x)
    {
        finalBoard = x;
    }



    @Override
    public String toString()
{

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
        for(int x = 0; x < pattern.length;x++)
         {
            for( int i =0; i<pattern[x].length;i++)
             {
                 pattern[x][i] = filler;
             }
        }
    }
}