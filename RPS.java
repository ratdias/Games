import java.util.Random;

/**
 * The RPS Class extends game, and it is coded to simulate a rock paper scissors game against randomly generated answers
 */
public class RPS extends Game{
    Random RNG;
    int numberOfWins;
    int numberOfLosses;
    int playerWins;
    int computerWin;
    String r = "rock";
    String p = "paper";
    String s = "scissors";
    String [] possiblePlays = new String[]{r,p,s};


    /**
     * RPS is the constructor
     * @param rng is the Random object used to generate the computer moves
     * @param requiredWins is the minimum number of wins needed to win the game
     * @param maxLosses if the maximum number of losses to lose the game
     */
    public RPS(Random rng, int requiredWins, int maxLosses){
        RNG = rng;
        numberOfLosses = maxLosses;
        numberOfWins = requiredWins;
    }

    /**
     * Re-initializes the variables to allow the user to play a new game everytime
     * @return a message to introduce the game
     */
    @Override
    protected String prepToPlay() {
        playerWins = 0;
        computerWin = 0;
        return ("Enter rock, paper, or scissors. Beat me " + numberOfWins +  " times before I win " + numberOfLosses+ " times!");
    }

    /**
     * the isOver method checks the number of times the computer/ player won to determine a winner
     * @retur true if the game is over, and false if it is not
     */
    @Override
    protected boolean isOver() {
        if (playerWins/2 == numberOfWins){
            return true;
        }
        else if (computerWin/2 == numberOfLosses){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * The isValid method checks if the moves are valid by checking if they are "rock", "paper", or "scissors"
     * @param move is the player move
     * @return true if it is valid, false if it is not
     */
    @Override
    protected boolean isValid(String move) {
        if (move.equals(r)){
            return true;
        }
        else if (move.equals(s)){
            return true;
        }
        else if (move.equals(p)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * The processMove method checks who win by following the traditional game rules. and it increments win and losses
     * @param move is the player move
     * @return a string indicating the computer move, the player move, and who won;
     */
    @Override
    protected String processMove(String move) {
        int choice = RNG.nextInt(3);
        String computerChoice = possiblePlays[choice];
        if (move.equals(r) && computerChoice.equals(r)) {
            return (computerChoice + " vs. "+ move + " We Tie");
        } else if (move.equals(r) && computerChoice.equals(s)) {
            playerWins++;
            return (computerChoice + " vs. " + move + " you Win");
        }
        else if(move.equals(r) && computerChoice.equals(p)){
            computerWin++;
            return (computerChoice + " vs. "+ move + " you lose");
        }
        else if (move.equals(p) && computerChoice.equals(p)) {
            return (computerChoice + " vs. "+ move + " We Tie");
        } else if (move.equals(p) && computerChoice.equals(r)) {
            playerWins++;
            return (computerChoice + " vs. "+ move + " you Win");
        }
        else if(move.equals(p) && computerChoice.equals(s)){
            computerWin++;
            return (computerChoice + " vs. "+ move + " you lose");
        }
        else if (move.equals(s) && computerChoice.equals(s)) {
            return (computerChoice + " vs. "+ move + " We Tie");
        } else if (move.equals(s) && computerChoice.equals(p)) {
            playerWins++;
            return (computerChoice + " vs. "+ move + " you Win");
        }
        else{
            computerWin++;
            return (computerChoice + " vs. "+ move + " you lose");
        }
    }

    /**
     * The finalMessage method indicates who won the game set
     * @return a message stating who won
     */
    @Override
    protected String finalMessage() {
        if (playerWins >= numberOfWins){
            return "You win the set";
        }
        else {
            return "you lose the set";
        }
    }

    @Override
    public String getName() {
        return "Rock Paper Scissors";
    }
}
