package elberger.maze;

import java.util.*;

public class Maze
{
	private int x;
	private int y;
	private Cell maze[][];
	private String north;
	private String south;
	private String east;
	private String west;
	private LinkedList<String> directions = new LinkedList<String>();
	//private LinkedList<Cell> visited = new LinkedList<Cell>();
	//private LinkedList<Cell> neighbors = new LinkedList<Cell>();
	private Stack<Cell> stack = new Stack();

	public Maze(int x, int y)
	{
		this.x = x;
		this.y = y;
		maze = new Cell[x][y];

		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				maze[i][j] = new Cell(i, j, false,
						true, true, true, true, "");
			}
		}
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public LinkedList<String> chooseDirection(Cell cell)
	{
		north = "north";
		south = "south";
		east = "east";
		west = "west";

		if (cell.getY() != 0)
		{
			directions.push(north);
		}
		if (cell.getY() <= (getY() - 1))
		{
			directions.push(south);
		}
		if (cell.getX() != 0)
		{
			directions.push(west);
		}
		if (cell.getX() < (getX() - 1))
		{
			directions.push(east);
		}

		Collections.shuffle(directions);
		return directions;
	}

	public void searchPath(Cell cell)
	{
		stack.push(cell);
		cell.setVisited(true);

		while (!stack.isEmpty())
		{
			Cell currentCell = stack.pop();
			String direction = chooseDirection(currentCell).getFirst();
			Cell nextCell = getNextCell(currentCell, direction);

			if (!nextCell.isVisited())
			{
				nextCell.setVisited(true);
				stack.push(nextCell);
				directions.clear();
			} else
			{
				stack.pop();
				searchPath(nextCell);
			}
		}
	}

	private Cell getNextCell(Cell currentCell, String direction)
	{
		Cell nextCell = null;

		if (direction == north)
		{
			nextCell = maze[currentCell.getX()][currentCell.getY() - 1];
			if (!nextCell.isVisited())
			{
				currentCell.setNorthWall(false);
				nextCell.setSouthWall(false);
			}
		}
		else if (direction == south)
		{
			nextCell = maze[currentCell.getX()][currentCell.getY() + 1];
			if (!nextCell.isVisited())
			{
				currentCell.setSouthWall(false);
				nextCell.setNorthWall(false);
			}
		}
		else if (direction == east)
		{
			nextCell = maze[currentCell.getX() + 1][currentCell.getY()];
			if (!nextCell.isVisited())
			{
				currentCell.setEastWall(false);
				nextCell.setWestWall(false);
			}
		}
		else if (direction == west)
		{
			nextCell = maze[currentCell.getX() - 1][currentCell.getY()];
			if (!nextCell.isVisited())
			{
				currentCell.setWestWall(false);
				nextCell.setEastWall(false);
			}
		}
		return nextCell;
	}

	public Cell startingCell()
	{
		Random x = new Random();
		Random y = new Random();
		Cell cell = new Cell(x.nextInt((getX() - 0 + 0)), y.nextInt((getY() - 0) + 0), false,
				true, true, true, true, "");
		return cell;
	}

	public Cell[][] displayMaze()
	{
		searchPath(startingCell());

		//StringBuilder display = new StringBuilder();
		for (int i = 0; i < x; i++)
		{
			for (int j = 0; j < y; j++)
			{
				if(maze[i][j].isSouthWall() == true && maze[i][j].isWestWall() == true)
				{
					//System.out.print("¯");
					//display.append("|_");
					maze[i][j].setValue("|_");
				}
				else if (maze[i][j].isSouthWall() == false && maze[i][j].isWestWall() == true)
				{
					maze[i][j].setValue("| ");
				}
				else if (maze[i][j].isSouthWall() == true && maze[i][j].isWestWall() == false)
				{
					maze[i][j].setValue(" _");
				}
				else if (maze[i][j].isSouthWall() == false && maze[i][j].isWestWall() == false)
				{
					maze[i][j].setValue("  ");
				}
			}
		}
		return maze;
	}

	public void generatePath()
	{
		searchPath(startingCell());
	}
}
