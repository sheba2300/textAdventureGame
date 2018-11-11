// Sheba Sow
package Game;
import java.util.Scanner;

import People.Person;
import People.Chaser;
import Rooms.MainRoom;
import Rooms.Rooms;
import People.Characters;
import Rooms.WinningRoom;
public class Runner
{
    private static boolean gameOn = true;
    private static boolean expert = false; // determines if user completed basic round yet
     private static int play; //saves user's response to "keep playing"
    private static boolean playing = true; //determines if user want to keep playign
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        while (playing) {
                gameOn = true;
                String playerName = "";
                String turkeyName = "";
                String action;
                int chosenHeight = 5;
                int chosenWidth = 5;
                //story/ plot of game
                System.out.println("You are coming home for thanksgiving dinner when you stumble upon a forest.");
                System.out.println("As you wander, you see a wild angry turkey.");
                System.out.println("He begins to chase you.");
                System.out.println("Get out of the forest before the turkey gets you.");
                System.out.println("");
                System.out.println("Enter your name");
                playerName = input.nextLine();
                System.out.println("Enter the name of the turkey that will be chasing you.");
                turkeyName = input.nextLine();
                MainRoom[][] building;
                Person player = new Person(playerName, 0, 0, "person");
                Chaser turkey = new Chaser(turkeyName, 2, 2, "chaser");
                if (expert) {
                    //let user choose their setup
                    System.out.println("Since you played this game before, you can now customize your own board");
                    System.out.println("Please enter the height of your board with a minimum of 6. EX: 6 will give you a board with 6 rows");
                    chosenHeight = input.nextInt();
                    System.out.println("Please enter the width of your board with a minimum of 6. EX: 6 will give you a board with 6 columns");
                    chosenWidth = input.nextInt();
                    building = new MainRoom[chosenHeight][chosenWidth];

                } else {
                    //default set up
                    building = new MainRoom[5][5];
                    building[4][4] = new WinningRoom(4, 4);


                }
                //builds rooms based on the setup given
                for (int x = 0; x < building.length; x++) {
                    for (int y = 0; y < building[x].length; y++) {
                        building[x][y] = new MainRoom(x, y);

                    }
                }
                //generates winning room at the end of the board
                building[chosenHeight-1][chosenWidth-1] = new WinningRoom(chosenHeight-1, chosenWidth-1);
                building[0][0].enterRoom(player);
                building[2][2].enterRoom(turkey);
                Board map = new Board(building);
                map.fill("| |");
                System.out.println(map.toString());
                while (gameOn) {
                    //user's turn to move
                    System.out.println("Where would you like to move? (Choose N, S, E, W)");
                    String move = in.nextLine();
                    if (validMove(move, player, building)) {
                        System.out.println("Your are located at " + player.getxLoc() + ", " + player.getyLoc());
                        building[turkey.getxLoc()][turkey.getyLoc()].leaveRoom(turkey);
                        action = turkey.getAction(turkey, building);
                        if (validMove(action, turkey, building)) {
                            if (action.equals("n"))
                                System.out.println(turkey.getFirstName() + " moved 1 space north");
                            else if (action.equals("s"))
                                System.out.println(turkey.getFirstName() + " moved 1 space south");
                            else if (action.equals("e"))
                                System.out.println(turkey.getFirstName() + " moved 1 space east");
                            else
                                System.out.println(turkey.getFirstName() + " moved 1 space west");
                        } else {
                            System.out.println("the turkey did not move");
                        }
                        //turkey's turn to move (generated my chaserRoom function)
                        System.out.println(turkey.getFirstName() + " is located at " + turkey.getxLoc() + "," + turkey.getyLoc());
                        building[turkey.getxLoc()][turkey.getyLoc()].enterRoom(turkey);

                    } else {
                        System.out.println("Please choose a valid move.");
                    }
                    //checks to see if user lost and if they wan t to play again
                    if (building[player.getxLoc()][player.getyLoc()].found(building[player.getxLoc()][player.getyLoc()].getOccupants()))
                    {
                        System.out.println(map.toString());
                        checkPlaying();
                        break;
                    }
                    System.out.println(map.toString());

                }

            }
            in.close();
            input.close();

    }

        /**
         * Checks that the movement chosen is within the valid game map.
         * @param move the move chosen
         * @param p person moving
         * @param building the 2D array of rooms
         * @return
         */
            public static boolean validMove(String move, Characters p, Rooms[][] building) {
            move = move.toLowerCase().trim();
            switch (move) {
                case "n":
                    if (p.getxLoc() > 0) {
                        building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        building[p.getxLoc() - 1][p.getyLoc()].enterRoom(p);
                        return true;
                    } else {
                        return false;
                    }
                case "e":
                    if (p.getyLoc() < building[p.getyLoc()].length - 1) {
                        building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        building[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
                        return true;
                    } else {
                        return false;
                    }

                case "s":
                    if (p.getxLoc() < building.length - 1) {
                        building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        building[p.getxLoc() + 1][p.getyLoc()].enterRoom(p);
                        return true;
                    } else {
                        return false;
                    }

                case "w":
                    if (p.getyLoc() > 0) {
                        building[p.getxLoc()][p.getyLoc()].leaveRoom(p);
                        building[p.getxLoc()][p.getyLoc() - 1].enterRoom(p);
                        return true;
                    } else {
                        return false;
                    }
                default:
                    break;

            }

return true;

        }
    public static void gameOff()
    {
        gameOn = false;
    }
    public static void makeExpert()
    {
        expert = true;
    }

    public static void checkPlaying()
    {
        Scanner userOutput = new Scanner(System.in);
        System.out.println("Would you like to play again?");
        System.out.println("Once you win the game you will be able to play your own customized board.");
        System.out.println("Press 1 to keep playing or press 2 to end the game");
        play = userOutput.nextInt();
        if(play == 2)
        {
            playing = false;
            gameOff();
        }
        return;
    }

}
