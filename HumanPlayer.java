public class HumanPlayer extends Player {

    public HumanPlayer(boolean isPlayerOne)
    {
        super(isPlayerOne);
    }

    // This function returns true if the player is human, otherwise - returns false.
    public boolean isHuman()
    {
        return true;
    }
}
