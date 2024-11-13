import java.util.ArrayList;
import java.util.*;

public class GreedyAI extends AIPlayer {

    public GreedyAI(boolean isPlayerOne)
    {
        super(isPlayerOne);
    }

    // This function gets an array of moves and returns the move with the most flips
    public Move makeMove(PlayableLogic game)
    {
        List<Position> positions = game.ValidMoves();
        Position max_position = positions.getFirst();
        int max_flips = game.countFlips(max_position);
        int current_flips;

        for (int i = 1; i < positions.size(); i++)
        {
            current_flips = game.countFlips(positions.get(i));
            if (current_flips > max_flips)
            {
                max_flips = current_flips;
                max_position = positions.get(i);
            }
        }

        //Move move = new Move(game, max_position, );// add disc





//        // init
//        int max_moves = moves.getFirst().number_of_flips;
//        Move move = moves.getFirst();
//
//        for (int i = 1; i < moves.size(); i++)
//        {
//            Move current_move = moves.get(i); // get the current move
//            if (current_move.number_of_flips > max_moves) // check if the current move has the most number of flips
//            {
//                // update the move to be returned to the current move
//                max_moves = current_move.number_of_flips;
//                move = current_move;
//            }
//        }
//
//        return move;

        return null;
    }
}
