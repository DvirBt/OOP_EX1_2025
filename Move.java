import java.util.ArrayList;

public class Move {

    private int x;
    private int y;

    protected int number_of_flips;


    public Move(Player p)
    {
        p.
    }

    public boolean MakeMove(GameLogic game)
    {

        if (game.isGameFinished())
        {
            return false;
        }

        for (int i = 0; i < game.getBoardSize(); i++)
        {
            for (int j = 0; j < game.getBoardSize(); j++)
            {
                if (game.)
            }
        }
    }

    public ArrayList<Move> getAllMoves(GameLogic game, Position p)
    {
        Disc disc = game.getDiscAtPosition(p);
    }
}
