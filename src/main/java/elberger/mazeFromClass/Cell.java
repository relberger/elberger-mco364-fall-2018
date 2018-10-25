package elberger.mazeFromClass;

import javax.annotation.Nonnull;

public class Cell
{

	private int x;
	private int y;
	private boolean visited;
	private boolean northWall;
	private boolean southWall;
	private boolean eastWall;
	private boolean westWall;

	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
		northWall = true;
		southWall = true;
		eastWall = true;
		westWall = true;
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

	public String toString()
	{
		return (isSouthWall() ? "_" : " ") +
				(isEastWall() ? "|" : " ");
	}

	public void removeWalls(@Nonnull Cell neighbor)
	{

		if (x == neighbor.x)
		{
			if (y == neighbor.y + 1)
			{
				// SOUTH
				southWall = false;
				neighbor.northWall = false;
			}
			else if (y == neighbor.y - 1)
			{
				// NORTH
				northWall = false;
				neighbor.southWall = false;
			}
		}
		if (y == neighbor.y)
		{
			if (x == neighbor.x + 1)
			{
				// EAST
				eastWall = false;
				neighbor.westWall = false;
			}
			else if (x == neighbor.x - 1)
			{
				westWall = false;
				neighbor.eastWall = false;
			}
		}

	}
}