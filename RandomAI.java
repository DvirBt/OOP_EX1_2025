import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomAI extends AIPlayer {
    public RandomAI(boolean isPlayerOne)
    {
        super(isPlayerOne);
    }

    // This function gets an array of possible moves and returns a random move.
    public Move makeMove(PlayableLogic game)
    {
        List<Position> positions = game.ValidMoves();
        Random r = new Random();
        int random = r.nextInt(positions.size()); // generate a random number out of the possible moves
        Position position = positions.get(random); // select the chosen move
        Move move = new Move();
    }
}
