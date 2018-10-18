package elberger.maze;

public class Player
{
	private int x;
	private int y;
	private Cell cell;

	public Player(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public Cell getCell()
	{
		return cell;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public void setCell(Cell cell)
	{
		this.cell = cell;
	}
}
