public class SimpleDisc implements Disc{

    private Player player;
    public Player getOwner()
    {
        return this.player;
    }

    public void setOwner(Player player)
    {
        this.player = player;
    }

    public String getType()
    {
        return "⬤";
    }
}
