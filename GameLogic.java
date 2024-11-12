import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class GameLogic implements PlayableLogic {

    private final int row_board = 8; // determines the length of the board
    private final int col_board = 8; // determines the width of the board
    private Player player1;
    private Player player2;
    private int discs_counter;
    //private boolean status; // determines the status of the game.
    private boolean turn; // false - player 1, true - player 2
    private final Disc[][] discs_mat = new Disc[this.row_board][this.col_board];
    //private List<Position> positions;
    private List<Move> moves;

    private List<Disc> p1_discs;
    private List<Disc> p2_discs;

    public GameLogic()
    {
        this.player1 = new HumanPlayer(true);
        this.player2 = new HumanPlayer(false);
        this.discs_counter = 4;
        this.turn = false; // first player's turn
        // place initial discs
        SimpleDisc disc = new SimpleDisc();
        disc.setOwner(player1);
        discs_mat[3][3] = disc;
        discs_mat[4][4] = disc;
        disc.setOwner(player2);
        discs_mat[3][4] = disc;
        discs_mat[4][3] = disc;
    }

    public GameLogic(GameLogic game)
    {
        this.player1 = game.getFirstPlayer();
        this.player2 = game.getSecondPlayer();
        // CREATE FUNCTIONS
        this.turn = game.turn;
        this.discs_counter = game.discs_counter;
        // Move list
    }
    public GameLogic(Player player1, Player player2)
    {
        moves = new ArrayList<>();
        this.discs_counter = 4;
        setPlayers(player1, player2);
        this.turn = false;
        //this.status = true;
    }

    public GameLogic(List<Move> moves, Player player1, Player player2, boolean turn)
    {
        this.moves = moves;
        this.player1 = player1;
        this.player2 = player2;
        this.turn = turn;
    }

    /**
     * Attempt to locate a disc on the game board.
     *
     * @param a The position for locating a new disc on the board.
     * @return true if the move is valid and successful, false otherwise.
     */
    public boolean locate_disc(Position a, Disc disc)
    {
        List<Position> valid_moves = ValidMoves();
        for (int i = 0; i < valid_moves.size(); i++)
            if (valid_moves.contains(a)) // if a is a valid move
            {
                discs_mat[a.getRow()][a.getCol()] = disc;
                this.discs_counter++; // add 1 to the counter
                this.turn = !this.turn; // turn changes
                return true;
            }

        return false;
    }

    /**
     * Get the disc located at a given position on the game board.
     *
     * @param position The position for which to retrieve the disc.
     * @return The piece at the specified position, or null if no disc is present.
     */
    public Disc getDiscAtPosition(Position position)
    {
        Disc disc = null;
        if (inside_board(position))
        {
            disc = discs_mat[position.getRow()][position.getCol()];
        }

        return disc;
    }

    /**
     * Get the size of the game board.
     *
     * @return The size of the game board, typically as the number of rows or columns.
     */
    public int getBoardSize()
    {
        return this.row_board;
    }

    /**
     * Get a list of valid positions for the current player.
     *
     * @return A list of valid positions where the current player can place a disc.
     */
    public List<Position> ValidMoves()
    {
        List<Position> list = new ArrayList<>();
        Position position;

        for (int i = 0; i < this.row_board; i++)
        {
            for (int j = 0; j < this.col_board; j++)
            {
                position = new Position(i, j);
                if (countFlips(position) > 0)
                    list.add(position);
            }
        }

        return list;
    }

    /**
     * Indicates if a disc in a given position belongs to the given player.
     *
     * @param player The current player.
     * @param  position A given position.
     * @return True if in the given position there is an enemy's disc. Otherwise returns false.
     */

    private boolean enemyDisc(Player player, Position position)
    {
        Player owner = discs_mat[position.getRow()][position.getCol()].getOwner();
        if (owner != player && owner != null)
            return true;

        return false;
    }

    /**
     * Count the number of flips in a row to the right from a given position.
     *
     * @param player The current player.
     * @param  position A given position.
     * @return the number of flips in the same row to the right side.
     */

    private int count(Player player, Position position, Position direction)
    {
        int counter = 0;
        Position current_position = new Position(position.getRow() + direction.getRow(), position.getCol() + direction.getCol());

        while (inside_board(current_position)) // while the position in the board
        {
            if (enemyDisc(player, current_position))
            {
                counter++;
                current_position = new Position(position.getRow() + direction.getRow(), position.getCol() + direction.getCol()); // update the position
            }

            else if (discs_mat[current_position.getRow()][current_position.getCol()].getOwner() == player) // current player's disc \ ally disc
                return counter;

            else // null, no disc at the position
                break;

        }

        return 0;
    }

    private boolean inside_board(Position position)
    {
        if (position.getRow() >= 0 && position.getCol() >= 0)
            if (position.getRow() < this.getBoardSize() && position.getCol() < this.getBoardSize())
                return true;

        return false;
    }

    private Position[] directions()
    {
        Position pos1 = new Position(0, 1); // go right
        Position pos2 = new Position(0, -1); // go left
        Position pos3 = new Position(1, 0); // go down
        Position pos4 = new Position(-1,0); // go up
        Position pos5 = new Position(1, 1); // go down right
        Position pos6 = new Position(1, -1); // go down up
        Position pos7 = new Position(-1, 1); // go up right
        Position pos8 = new Position(-1, -1); // go up left
        Position[] positions = new Position[] {pos1, pos2, pos3, pos4, pos5, pos6, pos7, pos8};

        return positions;
    }

    /**
     * The number of discs that will be flipped
     *
     * @return The number of discs that will be flipped if a disc will be placed in the 'a'.
     */
    public int countFlips(Position a)
    {
        int counter = 0;
        int row = a.getRow();
        int col = a.getCol();
        Player current_player;
        if (this.isFirstPlayerTurn())
            current_player = this.player1;
        else
            current_player = this.player2;

        // create an array of all directions
        Position[] direcitons = directions();

        for (int i = 0; i < direcitons.length; i++)
        {
            counter += count(current_player, a, direcitons[i]);
        }

        return counter;
    }

    /**
     * Get the first player.
     *
     * @return The first player.
     */
    public Player getFirstPlayer()
    {
        return this.player1;
    }

    /**
     * Get the second player.
     *
     * @return The second player.
     */
    public Player getSecondPlayer()
    {
        return this.player2;
    }

    /**
     * Set both players for the game.
     *
     * @param player1 The first player.
     * @param player2 The second player.
     */
    public void setPlayers(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Check if it is currently the first player's turn.
     *
     * @return true if it's the first player's turn, false if it's the second player's turn.
     */
    public boolean isFirstPlayerTurn()
    {
        return this.turn;
    }

    // Game state
    /**
     * Check if the game has finished, indicating whether a player has won or if it's a draw.
     *
     * @return true if the game has finished, false otherwise.
     */
    public boolean isGameFinished()
    {
        if (this.discs_counter == Math.multiplyExact(this.row_board, this.col_board))
            return true;

        return false;
    }

    /**
     * Reset the game to its initial state, clearing the board and player information.
     */
    public void reset()
    {
        this();
    }

    /**
     * Undo the last move made in the game, reverting the board state and turn order.
     * Works only with 2 Human Players, and does not work when AIPlayer is playing.
     */
    public void undoLastMove()
    {
        // if both players are human && not none won yet
        if (this.player1.isHuman() && this.player2.isHuman() && !isGameFinished())
        {
            // list of moves -> pop the last and create a constructor with the same data
//            this.moves.removeLast();
//            super(moves, this.player1, this.player2, this.turn);
            this.moves.removeLast(); // remove last move
            this.discs_counter--;
        }
    }
}
