public abstract class BombDisc implements Disc{

    protected Player player;

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
        return   "💣";
    }
}
