package elberger.maze;

public class Cell
{
	private int x;
	private int y;
	private boolean visited;
	private String northWall;
	private String southWall;
	private String eastWall;
	private String westWall;

	public Cell(int x, int y, boolean visited, String northWall, String southWall, String eastWall, String westWall)
	{
		this.x = x;
		this.y = y;
		this.visited = visited;
		this.northWall = northWall;
		this.southWall = southWall;
		this.eastWall = eastWall;
		this.westWall = westWall;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public boolean isVisited()
	{
		return visited;
	}

	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

	public String isNorthWall()
	{
		return northWall;
	}

	public void setNorthWall(String northWall)
	{
		this.northWall = northWall;
	}

	public String isSouthWall()
	{
		return southWall;
	}

	public void setSouthWall(String southWall)
	{
		this.southWall = southWall;
	}

	public String isEastWall()
	{
		return eastWall;
	}

	public void setEastWall(String eastWall)
	{
		this.eastWall = eastWall;
	}

	public String isWestWall()
	{
		return westWall;
	}

	public void setWestWall(String westWall)
	{
		this.westWall = westWall;
	}
}