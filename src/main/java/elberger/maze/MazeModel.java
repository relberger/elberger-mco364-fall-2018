package elberger.maze;

import java.util.*;

public class MazeModel
{
	private MazeController controller = new MazeController();
	private Cell startingCell = controller.startingCell();
	private int x;
	private int y;
	private String maze[][];
	private LinkedList<Cell> visited;

	public MazeModel(int x, int y)
	{
		this.x = x;
		this.y = y;
		maze = new String[x][y];
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

	public void makePath(Cell startingCell)
	{
		Cell currentCell = startingCell;
		visited.push(currentCell);

		LinkedList<Cell> neighbors = findNeighbors(currentCell);

		for (int i = 0; i < neighbors.size(); i++)
		{
			if (visited.contains(neighbors.get(i)))
			{
				maze[neighbors.get(i).getX()][neighbors.get(i).getY()] = "-";
				i++;
			}
			else
			{
				maze[neighbors.get(i).getX()][neighbors.get(i).getY()] = " ";
				currentCell = neighbors.get(i);
				makePath(currentCell);
			}
		}
	}
}