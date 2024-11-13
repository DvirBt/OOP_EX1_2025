import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Move {
    private Position position; // position of the new disc
    private Disc disc; // the disc to place
    private Disc[][] board; // the current status of the borad

    public Move()
    {
        
    }

    public Move(Position position, Disc disc, Disc[][] board)
    {
        this.position = position;
        this.disc = disc;
        this.board = board;
    }

    public Move(GameLogic game, Position position, Disc disc)
    {
        //this.game = new GameLogic(game);

    }



//    public PlayableLogic Undo(Stack<PlayableLogic> games)
//    {
//        if (!games.empty())
//            return games.pop();
//
//        return null; // no previous
//    }
}
