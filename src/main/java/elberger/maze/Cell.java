package elberger.maze;

public class Cell
{
	private int x;
	private int y;
	private boolean visited = false;
	private boolean northWall = true;
	private boolean southWall = true;
	private boolean eastWall = true;
	private boolean westWall = true;

	public Cell(int x, int y)
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

	public boolean isVisited()
	{
		return visited;
	}

	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

	public boolean isNorthWall()
	{
		return northWall;
	}

	public void setNorthWall(boolean northWall)
	{
		this.northWall = northWall;
	}

	public boolean isSouthWall()
	{
		return southWall;
	}

	public void setSouthWall(boolean southWall)
	{
		this.southWall = southWall;
	}

	public boolean isEastWall()
	{
		return eastWall;
	}

	public void setEastWall(boolean eastWall)
	{
		this.eastWall = eastWall;
	}

	public boolean isWestWall()
	{
		return westWall;
	}

	public void setWestWall(boolean westWall)
	{
		this.westWall = westWall;
	}

}