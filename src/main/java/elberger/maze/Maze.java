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

	public List<Cell> getUnvisitedNeighbors(Cell currentCell)
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
		else if (currentCell.getX() == nextCell.getX() - 1)
		{
			currentCell.setEastWall(false);
			nextCell.setWestWall(false);
		}
		//neighbor = west
		else if (currentCell.getX() == nextCell.getX() + 1)
		{
			currentCell.setWestWall(false);
			nextCell.setEastWall(false);
		}
	}

	public void searchPath()
	{
		int visitedCellCount = 0;
		Stack<Cell> stack = new Stack<>();
		Cell cell = maze[0][0];

		//starting cell
		cell.setVisited(true);
		stack.push(cell);
		visitedCellCount++;

		//loop through whole maze
		while (visitedCellCount < (getHeight() * getWidth()))
		{
			List<Cell> neighbors = getUnvisitedNeighbors(cell);
			//if there are valid neighbors, visit them, break walls, push them onto stack, and set the next cell
			if (neighbors.size() > 0)
			{
				Cell nextCell = neighbors.get(0);
				if (!nextCell.isVisited())
				{
					nextCell.setVisited(true);
					visitedCellCount++;
					breakWalls(cell, nextCell);
					stack.push(nextCell);
					cell = nextCell;
				}
			}
			//if there are no valid neighbors, pop a cell off the stack and go back and try finding its valid neighbors
			else
			{
				cell = stack.pop();
			}
		}
	}

	@Override
	//print maze 
	public String toString()
	{
		StringBuilder display = new StringBuilder();

		for (int i = 0; i < getWidth(); i++)
		{
			for (int j = 0; j < getHeight(); j++)
			{
				Cell cell = maze[j][i];
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
