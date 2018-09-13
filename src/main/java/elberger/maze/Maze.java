package elberger.maze;

import java.util.*;

public class Maze
{
	private int x;
	private int y;
	private Cell cell;
	private String maze[][];
	private LinkedList<Cell> visited = new LinkedList<Cell>();
	private LinkedList<Cell> neighbors = new LinkedList<Cell>();
	private Stack stack = new Stack();

	public Maze(int x, int y)
	{
		this.x = x;
		this.y = y;
		maze = new String[x][y];
	}

	public String[][] fillAllMazeCells()
	{
		for (int x = 0; x < this.x; x++)
		{
			for (int y = 0; y < this.y; y++)
			{
				maze[x][y] = "_";
			}
		}
		return maze;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public LinkedList<Cell> getNeighbors(Cell cell)
	{
		if (cell.getX() == 0)
		{
			Cell eastNeighbor = new Cell(cell.getX(), cell.getY() - 1);
			Cell westNeighbor = new Cell(cell.getX(), cell.getY() + 1);
			Cell southNeighbor = new Cell(cell.getX() + 1, cell.getY());

			neighbors.push(eastNeighbor);
			neighbors.push(westNeighbor);
			neighbors.push(southNeighbor);
		}

		else if (cell.getY() == 0)
		{
			Cell northNeighbor = new Cell(cell.getX() - 1, cell.getY());
			Cell westNeighbor = new Cell(cell.getX(), cell.getY() + 1);
			Cell southNeighbor = new Cell(cell.getX() + 1, cell.getY());

			neighbors.push(northNeighbor);
			neighbors.push(westNeighbor);
			neighbors.push(southNeighbor);
		}

		else if (cell.getY() == y)
		{
			Cell northNeighbor = new Cell(cell.getX() - 1, cell.getY());
			Cell eastNeighbor = new Cell(cell.getX(), cell.getY() - 1);
			Cell southNeighbor = new Cell(cell.getX() + 1, cell.getY());

			neighbors.push(northNeighbor);
			neighbors.push(eastNeighbor);
			neighbors.push(southNeighbor);
		}

		else if (cell.getX() == x)
		{
			Cell northNeighbor = new Cell(cell.getX() - 1, cell.getY());
			Cell eastNeighbor = new Cell(cell.getX(), cell.getY() - 1);
			Cell westNeighbor = new Cell(cell.getX(), cell.getY() + 1);

			neighbors.push(northNeighbor);
			neighbors.push(eastNeighbor);
			neighbors.push(westNeighbor);
		}

		else
		{
			Cell northNeighbor = new Cell(cell.getX() - 1, cell.getY());
			Cell eastNeighbor = new Cell(cell.getX(), cell.getY() - 1);
			Cell westNeighbor = new Cell(cell.getX(), cell.getY() + 1);
			Cell southNeighbor = new Cell(cell.getX() + 1, cell.getY());

			neighbors.push(northNeighbor);
			neighbors.push(eastNeighbor);
			neighbors.push(westNeighbor);
			neighbors.push(southNeighbor);
		}

		Collections.shuffle(neighbors);
		return neighbors;
	}

	public void setNeighbors(LinkedList<Cell> neighbors)
	{
		this.neighbors = neighbors;
	}


	public Cell startingCell()
	{
		Random x = new Random();
		Random y = new Random();
		Cell cell = new Cell(x.nextInt(getX()), y.nextInt(getY()));
		return cell;
	}

	public void searchPath(Cell cell)
	{
		stack.push(cell);
		visited.push(cell);

		while (!stack.isEmpty())
		{
			Cell currentCell = (Cell) stack.peek();
			Cell nextCell = getNeighbors(currentCell).getFirst();
			if (!visited.contains(nextCell))
			{
				visited.push(nextCell);
				maze[nextCell.getX()][nextCell.getY()] = ".";
				stack.push(nextCell);
			}
			else
			{
				stack.pop();
				searchPath(nextCell);
			}
		}
	}

	public void generatePath()
	{
		searchPath(startingCell());
	}
}
