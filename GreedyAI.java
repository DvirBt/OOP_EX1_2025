import java.util.ArrayList;

public abstract class GreedyAI extends AIPlayer {

    public GreedyAI(boolean isPlayerOne)
    {
        super(isPlayerOne);
    }

    // This function gets an array of moves and returns the move with the most flips
    public static Move GreedyMove(ArrayList<Move> moves)
    {
        // init
        int max_moves = moves.getFirst().number_of_flips;
        Move move = moves.getFirst();

        for (int i = 1; i < moves.size(); i++)
        {
            Move current_move = moves.get(i); // get the current move
            if (current_move.number_of_flips > max_moves) // check if the current move has the most number of flips
            {
                // update the move to be returned to the current move
                max_moves = current_move.number_of_flips;
                move = current_move;
            }
        }

        return move;
    }
}
