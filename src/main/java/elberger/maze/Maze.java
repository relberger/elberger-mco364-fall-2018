package elberger.maze;

import java.util.*;

public class Maze
{
	private int width;
	private int height;
	private Cell maze[][];

	public Maze(int width, int height)
	{
		this.width = width;
		this.height = height;
		maze = new Cell[width][height];

		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				maze[i][j] = new Cell(i, j);
			}
		}
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public List<Cell> getNeighbors(Cell currentCell)
	{
		List<Cell> neighbors = new ArrayList<>();

		//add north neighbor
		if (currentCell.getY() != 0)
		{
			neighbors.add(maze[currentCell.getX()][currentCell.getY() - 1]);
		}
		//get south neighbor
		if (currentCell.getY() < (getHeight() - 1))
		{
			neighbors.add(maze[currentCell.getX()][currentCell.getY() + 1]);
		}
		//get west neighbor
		if (currentCell.getX() != 0)
		{
			neighbors.add(maze[currentCell.getX() - 1][currentCell.getY()]);
		}
		//get east neighbor
		if (currentCell.getX() < (getWidth() - 1))
		{
			neighbors.add(maze[currentCell.getX() + 1][currentCell.getY()]);
		}

		Collections.shuffle(neighbors);
		return neighbors;
	}

	private void breakWalls(Cell currentCell, Cell nextCell)
	{
		//neighbor = north
		if (currentCell.getY() == nextCell.getY() + 1)
		{
			currentCell.setNorthWall(false);
			nextCell.setSouthWall(false);
		}
		//neighbor = south
		else if (currentCell.getY() == nextCell.getY() - 1)
		{
			currentCell.setSouthWall(false);
			nextCell.setNorthWall(false);
		}
		//neighbor = east
		else if (currentCell.getX() == nextCell.getX() + 1)
		{
			currentCell.setEastWall(false);
			nextCell.setWestWall(false);
		}
		//neighbor = west
		else if (currentCell.getX() == nextCell.getX() - 1)
		{
			currentCell.setWestWall(false);
			nextCell.setEastWall(false);
		}
	}

	public void searchPath(Cell cell)
	{
		Stack<Cell> stack = new Stack<>();
		stack.push(cell);
		cell.setVisited(true);

		while (!stack.isEmpty())
		{
			Cell currentCell = stack.pop();
			Cell nextCell = getNeighbors(currentCell).get(0);

			if (!nextCell.isVisited())
			{
				nextCell.setVisited(true);
				breakWalls(currentCell, nextCell);
				stack.addAll(getNeighbors(currentCell));
			}
			else
			{
				for (int i = 0; i < getNeighbors(currentCell).size(); i++)
				{
					if (getNeighbors(currentCell).get(i).isVisited())
					{
						stack.remove(getNeighbors(currentCell).get(i));
					}
				}
			}
		}
	}

	@Override
	public String toString()
	{
		searchPath(maze[0][0]);

		StringBuilder display = new StringBuilder();

		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				Cell cell = maze[i][j];
				if (cell.isSouthWall())
				{
					display.append("_");
				} else
				{
					display.append(" ");
				}
				if (cell.isEastWall())
				{
					display.append("|");
				} else
				{
					display.append(" ");
				}
			}
			display.append("\n");
		}

		return display.toString();
	}
}
