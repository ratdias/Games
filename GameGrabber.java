import java.util.Scanner;
import java.util.Random;

/**
 * the GameGrabber class is the class responsible for creating the menu of games and allow the user to keep choosing games
 * This class provides the interaction with the user needed to select a game, and quit from it
 */
public class GameGrabber {
    private Random RNG = new Random();
    private Game[] games;
    private Scanner user;
    private int choice;

    /**
     * the GameGrabber is the constructor
     * @param games is the array of game objects that will be played
     * @param user is the user input
     */
    public GameGrabber(Game[] games, Scanner user){
        this.games = games;
        this.user = user;
    }

    /**
     * The doMenu method iterates through the games array and prints each available game allowing for the user to quit and select any of the
     * games with the scanner object
     */
    public void doMenu(){
        while (true) {
            for (int i = 0; i < games.length; i++) {
                System.out.println(i + ") " + games[i].getName());
            }
            System.out.println(games.length + ") Quit");
            System.out.print("Pick a game (0-" + games.length + ") ");
            choice = user.nextInt();
            if (choice == games.length) {
                System.out.println("goodbye");
                break;
            }
            while ((choice > games.length) || (choice < 0)) {
                System.out.print("Pick a game (0-" + games.length + ") ");
                choice = user.nextInt();
            }
            games[choice].play(user);
        }
    }

    /**
     * the main function initializes an array of all the games providing the data for the games to played, and it created a menu with
     * the initialized array 
     * @param args
     */
    public static void main(String[] args){
        Scanner user = new Scanner(System.in);
        Random rng = new Random();
        WordsList wrdLst = new WordsList(rng);
        Game[] gamesArray = new Game[4];
        Hangman hangManGame = new Hangman(wrdLst, 4, 8, 20);
        NumberGuesser numGuesserGame = new NumberGuesser(rng, 100, 8 );
        RPS rockpaperScissors = new RPS(rng, 3, 3);
        WordJumble wordJumbleGame = new WordJumble(wrdLst, rng, 4, 8, 20);
        gamesArray[0] = hangManGame;
        gamesArray[1] = numGuesserGame;
        gamesArray[2] = rockpaperScissors;
        gamesArray[3] = wordJumbleGame;
        GameGrabber chooseGame = new GameGrabber(gamesArray, user);
        chooseGame.doMenu();
    }

}
