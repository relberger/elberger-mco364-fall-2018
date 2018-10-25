package elberger.mazeFromClass;

import java.util.Random;
import java.util.Stack;

public class MazeBuilder
{

	private static final Random R = new Random();
	private Maze maze;

	public MazeBuilder(int columns, int rows)
	{
		maze = new Maze(columns, rows);
	}

	public MazeBuilder randomize()
	{

		Stack<Cell> stack = new Stack<>();
		Cell cell = maze.getCell(0, 0);

		stack.add(cell);

		while (!stack.isEmpty())
		{
			cell = stack.pop();
			cell.setVisited(true);

			Cell neighbor = maze.getNotVisitedNeighbor(
					cell.getColumn(), cell.getRow());

			if (neighbor == null)
			{
				continue;
			}

			cell.removeWalls(neighbor);

			stack.push(cell);
			stack.push(neighbor);
		}

		return this;
	}

	public Maze build()
	{
		return maze;
	}

}