
import java.util.Random;

/**
 *The wordJumble Class extends game, and it is coded to simulate a word jumble game
 */

public class WordJumble extends Game {
    Random RNG;
    WordsList wordList;
    int min;
    int max;
    int maxGuessesAllowed;
    String randomWord;
    String randomShuffledWord;
    public int currentGuesses = 0;
    boolean playerWon;

    /**
     * WordJumble is the constructor. The method initializes every useful variables.
     * @param wl WordList object ued to generate word
     * @param rng Random objct used for shuffling the word
     * @param minWordLen minimum length
     * @param maxWordLen maximum length
     * @param maxGuesses maximum number of guesses allowed
     */
    WordJumble(WordsList wl, Random rng, int minWordLen, int maxWordLen, int maxGuesses){
        wordList = wl;
        RNG = rng;
        min = minWordLen;
        max = maxWordLen;
        maxGuessesAllowed = maxGuesses;
    }

    /**
     * Re-initializes the variables to allow the user to play a new game everytime, and it creates a char array for the shuffle operation
     * @return a message to introduce the game
     */
    @Override
    protected String prepToPlay() {
        playerWon = false;
        currentGuesses = 0;
        randomWord = wordList.getWord(min, max);
        char[] jumbledWord = randomWord.toCharArray();
        randomShuffledWord = shuffle(jumbledWord);
        return ("The following is a jumbled up word: " + randomShuffledWord + " You get " + maxGuessesAllowed + " guesses to guess it");
    }

    /**
     * the isOver method indicates if the game is over by checking if the limit of guesses was reached or if the word was guessed correctly
     * @return true if the game is over, and false if it is not
     */
    @Override
    protected boolean isOver() {
        if(currentGuesses/2 == maxGuessesAllowed || playerWon == true){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    protected boolean isValid(String move) {
        return true;
    }

    /**
     * the processMove Method checks if the input from the user is the same as the target word, and it increments the guesses
     * @param move is the move from the user
     * @return "That’s not it" if the word was found or "" if not
     */
    @Override
    protected String processMove(String move) {
        if (!move.equals(randomWord)){
            currentGuesses++;
            return "That’s not it";
        }
        else {
            playerWon = true;
            return "";
        }
    }

    @Override
    protected String finalMessage() {
        return ("The word was " + randomWord);
    }

    @Override
    public String getName() {
        return "Word jumble";
    }

    /**
     * The shuffle method is the Fisher-Yates algorithm that iterates through a loop and shuffle 2 stored values at a time
     * @param array char array made out of the word
     * @return a Shuffled string
     */
    public String shuffle(char[] array) {
        int arrayLength = array.length;
        for (int i = arrayLength-1; i >= 0; i--){
            int j = RNG.nextInt(i+1);
            char storeOne = array[i];
            char storeTwo = array[j];
            array[j] = storeOne;
            array[i] = storeTwo;
        }
        return String.valueOf(array);
    }

}
