package elberger.maze;

import javax.annotation.Nonnull;

public class CellFromClass
{
	private int x;
	private int y;
	private boolean visited = false;
	private boolean northWall = true;
	private boolean southWall = true;
	private boolean eastWall = true;
	private boolean westWall = true;

	public CellFromClass(int x, int y)
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

	//@Nonnull is hint to compiler
	public void removeWalls(@Nonnull CellFromClass neighbor)
	{
		if (x == neighbor.x)
		{
			if (y > neighbor.y + 1)
			{
				//south
				southWall = false;
				neighbor.northWall = false;
			}
			else if(y == neighbor.y - 1)
			{
				//north
				northWall = false;
				neighbor.southWall = false;

			}
		}
		if (y == neighbor.y)
		{
			if (x > neighbor.x + 1)
			{
				//east
				eastWall = false;
				neighbor.westWall = false;

			}
			else if(x == neighbor.x - 1)
			{
				//west
				westWall = false;
				eastWall = false;

			}
		}
	}
}