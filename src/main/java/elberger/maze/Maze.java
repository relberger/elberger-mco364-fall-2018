package elberger.maze;

import java.util.*;

public class Maze
{
	private int x;
	private int y;
	private Cell cell;
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
				maze[i][j] = new Cell(i, j, false, "¯", "_", "|", "|");
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

	public LinkedList<String> chooseDirection()
	{
		north = "north";
		south = "south";
		east = "east";
		west = "west";
		directions.push(north);
		directions.push(south);
		directions.push(east);
		directions.push(west);

		Collections.shuffle(directions);
		return directions;
	}

	public void searchPath(Cell cell)
	{
		stack.push(cell);
		cell.setVisited(true);

		while (!stack.isEmpty())
		{
			Cell currentCell = stack.peek();
			String direction = chooseDirection().getFirst();
			Cell nextCell = getNextCell(currentCell, direction);

			if (!nextCell.isVisited())
			{
				nextCell.setVisited(true);
				stack.push(nextCell);
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
			nextCell = maze[currentCell.getX() - 1][currentCell.getY()];
			currentCell.setNorthWall("");
			nextCell.setSouthWall("");
		}
		else if (direction == south)
		{
			nextCell = maze[currentCell.getX() + 1][currentCell.getY()];
			currentCell.setSouthWall("");
			nextCell.setNorthWall("");
		}
		else if (direction == east)
		{
			nextCell = maze[currentCell.getX()][currentCell.getY() + 1];
			currentCell.setEastWall("");
			nextCell.setWestWall("");
		}
		else if (direction == west)
		{
			nextCell = maze[currentCell.getX()][currentCell.getY() - 1];
			currentCell.setWestWall("");
			nextCell.setEastWall("");
		}
		return nextCell;
	}

	public Cell startingCell()
	{
		Random x = new Random();
		Random y = new Random();
		Cell cell = new Cell(x.nextInt(getX()), y.nextInt(getY()), false, "¯", "_", "|", "|");
		return cell;
	}

	public void generatePath()
	{
		searchPath(startingCell());
	}
}
