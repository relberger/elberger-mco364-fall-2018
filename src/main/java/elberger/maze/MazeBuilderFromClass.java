package elberger.maze;

import java.util.Random;
import java.util.Stack;

public class MazeBuilderFromClass
{
	private MazeFromClass maze;
	private static final Random r = new Random();

	public MazeBuilderFromClass(int width, int height)
	{
		maze = new MazeFromClass(width, height);
	}

	public void randomize()
	{
		Stack<CellFromClass> stack = new Stack<>();
		CellFromClass cell = maze.getCell(0,0);

		stack.add(cell);

		while (!stack.isEmpty())
		{
			cell = stack.pop();
			cell.setVisited(true);

			CellFromClass neighbor = maze.getUnvisitedNeighbor(cell.getX(), cell.getY());
			if(neighbor == null)
			{
				//go back to start of loop
				continue;
			}

			cell.removeWalls(neighbor);

			stack.push(cell);
			stack.push(neighbor);
		}
	}

}
