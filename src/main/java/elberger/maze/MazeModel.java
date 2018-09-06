package elberger.maze;

import java.util.*;

public class MazeModel
{
	private MazeController controller = new MazeController();
	private int x = controller.maxRows();
	private int y = controller.maxCols();
	private int maze[][];
	private LinkedList<Cell> visited;
	private Queue<Cell> cells;


	public MazeModel(int x, int y, int[][] maze)
	{
		this.x = x;
		this.y = y;
		this.maze = maze;
	}

	public LinkedList<Cell> findNeighbors(Cell cell)
	{
		LinkedList<Cell> neighbors = null;

		Cell northNeighbor = new Cell(cell.getX() - 1, cell.getY());
		Cell eastNeighbor = new Cell(cell.getX(), cell.getY() - 1);
		Cell westNeighbor = new Cell(cell.getX(), cell.getY() + 1);
		Cell southNeighbor = new Cell(cell.getX() + 1, cell.getY());

		neighbors.add(northNeighbor);
		neighbors.add(eastNeighbor);
		neighbors.add(westNeighbor);
		neighbors.add(southNeighbor);

		Collections.shuffle(neighbors);
		return neighbors;
	}

	public void startMaze()
	{
		Cell cell = controller.startingCell();
		makePath(cell);
	}

	public void makePath(Cell cell)
	{
		Cell currentCell = cell;
		cells.add(currentCell);
		visited.add(currentCell);

		LinkedList<Cell> neighbors = findNeighbors(currentCell);

		for (int i = 0; i < neighbors.size(); i++)
		{
			if (visited.contains(neighbors.get(i)))
			{
				i++;
			}
			else
			{
				currentCell = neighbors.get(i);
				makePath(currentCell);
			}
		}
	}
}
