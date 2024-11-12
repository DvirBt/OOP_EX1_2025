import java.util.ArrayList;
import java.util.List;

public class Move {

    // List<Position> positions;
    private Position position;

    private Disc disc;

    private GameLogic game;

    public Move(AIPlayer p, GameLogic game)
    {
        //positions = game.ValidMoves(); // get all the possible moves
        p.makeMove(game);
    }

    public Move()
    {

    }

    public Move(GameLogic game)
    {
        if (!game.getFirstPlayer().isHuman())
        {

        }
    }

    public Move(GameLogic game, Position position, Disc disc)
    {
        this.game = new GameLogic(game);

    }

    public ArrayList<Move> getAllMoves(GameLogic game, Position p)
    {
        Disc disc = game.getDiscAtPosition(p);
    }
}
