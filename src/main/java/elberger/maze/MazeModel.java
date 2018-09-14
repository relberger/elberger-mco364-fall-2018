package elberger.maze;

import java.util.*;

public class MazeModel
{
	private MazeController controller = new MazeController();
	//private Cell startingCell = controller.startingCell();
	private int x;
	private int y;
	private String maze[][];
	private LinkedList<Cell> visited = new LinkedList<Cell>();

	public MazeModel(int x, int y)
	{
		this.x = x;
		this.y = y;
		maze = new String[x][y];
	}

	/*public LinkedList<Cell> findNeighbors(Cell cell)
	{
		LinkedList<Cell> neighbors = new LinkedList<Cell>();

		Cell northNeighbor = new Cell(cell.getWidth() - 1, cell.getHeight());
		Cell eastNeighbor = new Cell(cell.getWidth(), cell.getHeight() - 1);
		Cell westNeighbor = new Cell(cell.getWidth(), cell.getHeight() + 1);
		Cell southNeighbor = new Cell(cell.getWidth() + 1, cell.getHeight());

		neighbors.push(northNeighbor);
		neighbors.push(eastNeighbor);
		neighbors.push(westNeighbor);
		neighbors.push(southNeighbor);

		Collections.shuffle(neighbors);
		return neighbors;
	}

	public String makePath(Cell startingCell)
	{
		Cell currentCell = startingCell;
		visited.push(currentCell);

		LinkedList<Cell> neighbors = findNeighbors(currentCell);

		for (int i = 0; i < neighbors.size(); i++)
		{
			if (visited.contains(neighbors.get(i)))
			{
				maze[neighbors.get(i).getWidth()][neighbors.get(i).getHeight()] = "-";
				i++;
			}
			else
			{
				maze[neighbors.get(i).getWidth()][neighbors.get(i).getHeight()] = " ";
				currentCell = neighbors.get(i);
				makePath(currentCell);
			}
		}
		return maze.toString();
	}*/
}
