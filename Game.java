import java.util.Scanner;
import java.lang.String;

/**
 * The Game class in an Abstract class that serves the purpose of providing an outline for the concrete classes that extend Game.
 * This is done by the use of the protected abstract methods
 */

public abstract class Game {
    private String playerMov;
    private String name;
    protected abstract String prepToPlay();
    protected abstract boolean isOver();
    protected abstract boolean isValid(String move);
    protected abstract String processMove(String move);
    protected abstract String finalMessage();
    protected abstract String getName();

    /**
     * the play method is the only concrete method, and it is made to allow the user to play any of the Games (that extend the Game class).
     * To allow the user to play any number of times, all the interactions are inside a while loop. Play will prepare each game by calling
     * the prepToPlay method and asking for input of the user. The function will check if the move is valid, process it and let the player
     * know if the game is over
     * @param user is the scanner to provide user interaction through console inputs
     */
    public void play(Scanner user){
        System.out.println(prepToPlay());
        while (true) {
            System.out.print("Enter Your Move or 'quit' to quit> ");
            playerMov = user.next();
            while (!isValid(playerMov)) {
                playerMov = user.next();
                System.out.print("Invalid move! try again> ");
            }
            if (processMove(playerMov).equals(null)){
                System.out.print("");
            }
            else {
                System.out.println(processMove(playerMov));
            }
            if (isOver()) {
                System.out.println(finalMessage());
                break;
            }
        }
    }
}

