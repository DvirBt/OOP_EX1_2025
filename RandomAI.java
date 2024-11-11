import java.util.ArrayList;
import java.util.Random;

public abstract class RandomAI extends AIPlayer {

    protected boolean isPlayerOne;

    public RandomAI(boolean isPlayerOne)
    {
        super(isPlayerOne);
    }

    // This function gets an array of possible moves and returns a random move.
    public static Move RandomMove(ArrayList<Move> moves)
    {
        int number_of_moves = moves.size();
        Random r = new Random();
        int random = r.nextInt(moves.size()); // generate a random number out of the possible moves
        return moves.get(random); // select the random move
    }
}
