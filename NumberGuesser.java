import java.util.Random;
import java.util.Scanner;

/**
 * The NumberGuesser Class extends game, and it is coded to simulate a Number Guess game
 */
public class NumberGuesser extends Game {
    //initialization of variables
    private String GameName;
    private int guessMaxNumber;
    private int rangeNumber;
    private int RNGS;
    private int count = 0;
    private Scanner player = new Scanner(System.in);
    private int rangeNumber2;
    private int maxGuesses2;

    /**
     * The NumberGuesser method is the constructor, and it selects a random number
     * @param rng is a Random object used to generate the random number
     * @param maxNumber is the biggest number that can be generated
     * @param maxGuesses is the maximum number of guesses allowed
     */
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses){
        rangeNumber = maxNumber;
        guessMaxNumber = maxGuesses;
        rangeNumber2 = maxNumber;
        maxGuesses2 = maxGuesses;
        RNGS = rng.nextInt(maxNumber) + 1;

    }

    /**
     * Re-initializes the variables to allow the user to play a new game everytime
     * @return a message to introduce the game
     */
    @Override
    protected String prepToPlay() {
        count = 0;
        rangeNumber = rangeNumber2;
        guessMaxNumber = maxGuesses2;
        return ("I've picked a number 1 to " + rangeNumber + ". You get " + guessMaxNumber + " guesses to guess it!");
    }

    /**
     * the isOver method checks the number of guesses the player made, if the number is the same as the number of guesses the game is over
     * @return true if the game is over, and false if it is not
     */
    @Override
    protected boolean isOver() {
        // count is divided by 2 because count is incremented 2 at a time because of the null check that play does
        if (count/2 >= maxGuesses2){
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * isValid Checks if the move is valid by checking if it is a digit
     * @param move is the player move
     * @return true if it is valid, false if it is not
     */
    @Override
    protected boolean isValid(String move) {
        char[] playerMove = move.toCharArray();
        for (char i : playerMove){
            if (Character.isDigit(i)){
              continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    /**
     * The processMove method transforms the input String into an integer and increments the count
     * @param move is the player move
     * @return "too high" if the move is greater than the generated number, "too low" if it is lower or a message indicating that the move is equal to the number
     */
    @Override
    protected String processMove(String move) {
        int playerGuess = Integer.parseInt(move);
        if (playerGuess > RNGS){
            count++;
            return "Too High";
        }
        else if (playerGuess < RNGS){
            count++;
            return "Too Low";
        }
        else {
           count = count + 10000;
            return "That's it!";
        }
    }

    @Override
    protected String finalMessage() {
        return ("The final number was: " +  RNGS);
    }

    @Override
    public String getName() {
        return "Number Guesser";
    }

}
