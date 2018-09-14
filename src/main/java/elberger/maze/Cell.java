package elberger.maze;

public class Cell
{
	private int x;
	private int y;
	private boolean visited;
	private boolean northWall;
	private boolean southWall;
	private boolean eastWall;
	private boolean westWall;
	private String value;

	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
		visited = false;
		northWall = true;
		southWall = true;
		eastWall = true;
		westWall = true;
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

	/*public String getValue()
	{
		return value;
	}*/

	public void setValue(String value)
	{
		this.value = value;
	}

}