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
		List<Cell> unvisitedNeighbors = new ArrayList<>();

		//add north neighbor
		if (currentCell.getY() != 0 && !maze[currentCell.getX()][currentCell.getY() - 1].isVisited())
		{
			unvisitedNeighbors.add(maze[currentCell.getX()][currentCell.getY() - 1]);
		}
		//get south neighbor
		if (currentCell.getY() < (getHeight() - 1) && !maze[currentCell.getX()][currentCell.getY() + 1].isVisited())
		{
			unvisitedNeighbors.add(maze[currentCell.getX()][currentCell.getY() + 1]);
		}
		//get west neighbor
		if (currentCell.getX() != 0 && !maze[currentCell.getX() - 1][currentCell.getY()].isVisited())
		{
			unvisitedNeighbors.add(maze[currentCell.getX() - 1][currentCell.getY()]);
		}
		//get east neighbor
		if (currentCell.getX() < (getWidth() - 1) && !maze[currentCell.getX() + 1][currentCell.getY()].isVisited())
		{
			unvisitedNeighbors.add(maze[currentCell.getX() + 1][currentCell.getY()]);
		}

		Collections.shuffle(unvisitedNeighbors);
		return unvisitedNeighbors;
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
		cell = maze[0][0];
		cell.setVisited(true);
		stack.push(cell);

		while (stack.size() < (getHeight() * getWidth()))
		{
			List<Cell> neighbors = getNeighbors(cell);
			Cell nextCell = neighbors.get(0);

			if(!nextCell.isVisited())
			{
				nextCell.setVisited(true);
				breakWalls(cell, nextCell);
				stack.push(nextCell);
				cell = getNeighbors(cell).get(0);
			}
			else if (!stack.isEmpty())
			{
				cell = stack.pop();
			}
		}

/*		cell = maze[0][0];
		cell.setVisited(true);
		List<Cell> neighbors = getNeighbors(cell);

		for (int i = 0; i < neighbors.size(); i++)
		{
			if (!neighbors.get(i).isVisited())
			{
				searchPath(neighbors.get(i));
			}
		}*/

		/*Stack<Cell> stack = new Stack<>();
		//Cell startCell = maze[0][0];
		Cell startCell = cell;
		stack.push(startCell);
		startCell.setVisited(true);

		while (!stack.isEmpty())
		{
			Cell currentCell = stack.pop();
			List<Cell> neighbors = getNeighbors(currentCell);

			if (!neighbors.isEmpty())
			{
				Cell nextCell = neighbors.get(0);

				if (!nextCell.isVisited())
				{
					nextCell.setVisited(true);
					breakWalls(currentCell, nextCell);
					stack.push(nextCell);
				}
				else
				{
					for (int i = 0; i < neighbors.size(); i++)
					{
						if (neighbors.get(i).isVisited())
						{
							i++;
						}
					}
				}
			}
		}*/
	}

	@Override
	public String toString()
	{
		//don't call in this method
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
