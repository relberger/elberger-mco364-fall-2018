package elberger.mazeFromClass;

import javax.annotation.Nonnull;

public class Cell
{

	private int column;
	private int row;
	private boolean visited;
	private boolean northWall;
	private boolean southWall;
	private boolean eastWall;
	private boolean westWall;

	public Cell(int column, int row)
	{
		this.column = column;
		this.row = row;
		northWall = true;
		southWall = true;
		eastWall = true;
		westWall = true;
	}

	public int getColumn()
	{
		return column;
	}

	public int getRow()
	{
		return row;
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

		if (column == neighbor.column)
		{
			if (row == neighbor.row + 1)
			{
				// SOUTH
				northWall = false;
				neighbor.southWall = false;
			}
			else if (row == neighbor.row - 1)
			{
				// NORTH
				southWall = false;
				neighbor.northWall = false;
			}
		}
		else if (row == neighbor.row)
		{
			if (column == neighbor.column - 1)
			{
				// EAST
				eastWall = false;
				neighbor.westWall = false;
			}
			else if (column == neighbor.column + 1)
			{
				westWall = false;
				neighbor.eastWall = false;
			}
		}
		else {
			throw new IllegalStateException("Trying to remove walls of cells that aren't neighbors");
		}

	}
}