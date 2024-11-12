public class Position {

    private int row;
    private int col;

//    public Position()
//    {
//        this.x = 0;
//        this.y = 0;
//    }

    public Position(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return this.row;
    }

    public int getCol()
    {
        return this.col;
    }

    public String toString()
    {
        return "(" + this.row + "," + this.col + ")";
    }

    public Position getPosition()
    {
        return new Position(this.row, this.col);
    }
}
