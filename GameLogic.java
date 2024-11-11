import javax.swing.text.Position;
import java.util.List;

public abstract class GameLogic implements PlayableLogic {

    protected final int x_board = 8; // determines the length of the board
    protected final int y_board = 8; // determines the width of the board
    protected Player player1;
    protected Player player2;
    protected boolean status; // determines the status of the game.

    public GameLogic(Player player1, Player player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.status = true;

    }

    /**
     * Attempt to locate a disc on the game board.
     *
     * @param a The position for locating a new disc on the board.
     * @return true if the move is valid and successful, false otherwise.
     */
    public boolean locate_disc(Position a, Disc disc)
    {

    }

    /**
     * Get the disc located at a given position on the game board.
     *
     * @param position The position for which to retrieve the disc.
     * @return The piece at the specified position, or null if no disc is present.
     */
    public Disc getDiscAtPosition(Position position)
    {

    }

    /**
     * Get the size of the game board.
     *
     * @return The size of the game board, typically as the number of rows or columns.
     */
    public int getBoardSize()
    {

    }

    /**
     * Get a list of valid positions for the current player.
     *
     * @return A list of valid positions where the current player can place a disc.
     */
    public List<Position> ValidMoves()
    {

    }

    /**
     * The number of discs that will be flipped
     *
     * @return The number of discs that will be flipped if a disc will be placed in the 'a'.
     */
    public int countFlips(Position a)
    {

    }

    /**
     * Get the first player.
     *
     * @return The first player.
     */
    public Player getFirstPlayer()
    {

    }

    /**
     * Get the second player.
     *
     * @return The second player.
     */
    public Player getSecondPlayer()
    {

    }

    /**
     * Set both players for the game.
     *
     * @param player1 The first player.
     * @param player2 The second player.
     */
    public void setPlayers(Player player1, Player player2)
    {

    }

    /**
     * Check if it is currently the first player's turn.
     *
     * @return true if it's the first player's turn, false if it's the second player's turn.
     */
    public boolean isFirstPlayerTurn()
    {

    }

    // Game state
    /**
     * Check if the game has finished, indicating whether a player has won or if it's a draw.
     *
     * @return true if the game has finished, false otherwise.
     */
    public boolean isGameFinished()
    {

    }

    /**
     * Reset the game to its initial state, clearing the board and player information.
     */
    public void reset()
    {

    }

    /**
     * Undo the last move made in the game, reverting the board state and turn order.
     * Works only with 2 Human Players, and does not work when AIPlayer is playing.
     */
    public void undoLastMove()
    {

    }
}
