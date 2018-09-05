package elberger.maze;

import java.util.Random;

public class MazeController
{
	private int max = 25;
	private int min = 5;

	public MazeController()
	{

	}

	private int getRandomInt()
	{
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public int maxRows()
	{
		int rows = getRandomInt();
		return rows;
	}

	public int maxCols()
	{
		int columns = getRandomInt();
		return columns;
	}

	public MazeCell startingCell()
	{
		MazeCell start = new MazeCell(getRandomInt(), getRandomInt(), true);

		return start;
	}
}