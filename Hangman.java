import java.util.Random;

/**
 * The Hangman Class extends game, and it is coded to simulate a hangman game
 */
public class Hangman extends Game{
    // initialization of variables
    String alphabet = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
    Random rng = new Random();
    private int count = 0;
    int min;
    int minStable;
    int max;
    int maxStable;
    int guesses;
    int guessesStable;
    private String chosenWord;
    WordsList listOfWords;
    char[] blankArray;

    /**
     * Hangman is the constructor. The method initializes every useful variables
     * @param words is an object of the WordList class that is used to generate a word
     * @param minWordLen is the minimal length of the word
     * @param maxWordLen if the maximum length of the word
     * @param maxGuesses is the max allowed guesses that the player can make
     */
    public Hangman(WordsList words, int minWordLen, int maxWordLen, int maxGuesses){
        min = minWordLen;
        minStable = minWordLen;
        max = maxWordLen;
        maxStable = maxWordLen;
        guesses = maxGuesses;
        guessesStable = maxGuesses;
        listOfWords = words;
    }

    /**
     * The prepToPlay method initialize again the variables needed to set a new game, including creating the blank string that will serve as hint
     * @return a message to introduce the game
     */
    @Override
    protected String prepToPlay() {
        WordsList Hangman = listOfWords;
        chosenWord = Hangman.getWord(min, max);
        blankArray = new char[chosenWord.length()];
        min = minStable;
        max = maxStable;
        count = 0;
        blankArray = chosenWord.toCharArray();
        for (int i = 0; i < chosenWord.length(); i++){
            blankArray[i] = '_';
        }

        return "I’ve picked a " + chosenWord.length() + " letter word. Guess letters you think are in the word. You get " + guesses +  " guesses.";
    }

    /**
     * The isOver method check if the guesses have reached the maximum number of guesses or if the word was guessed correctly
     * @return true if the game is over, and false if it is not
     */

    @Override
    protected boolean isOver() {
        if (count == guesses || String.valueOf(blankArray).equals(chosenWord)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * The IsValid method checks if the move made by the player is valid by checking if it is a single letter in lower case
     * @param move is the player move
     * @return true if it is valid, false if it is not
     */
    @Override
    protected boolean isValid(String move) {
        if (alphabet.contains(move) && move.length()==1){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * The processMove Method checks if the word generated contains the guess, if so, it iterates through the word and change the blank letters
     * to the letter found in the generated random word
     * @param move is the player move
     * @return a string made by blank letters "_" and the actual letters (This is the hint)
     */
    @Override
    protected String processMove(String move) {
        char muv = move.charAt(0);
        if(chosenWord.contains(move)){
            for (int i = 0; i < chosenWord.length(); i++){
                if (muv == chosenWord.charAt(i)){
                    blankArray[i] = move.charAt(0);
                }
            }
        }
        else{
            return String.valueOf(blankArray);
        }
        count++;
        return String.valueOf(blankArray);
    }

    @Override
    protected String finalMessage() {
        return ("The word was: " + chosenWord);
    }

    @Override
    public String getName() {
        return "Hangman";
    }
}
