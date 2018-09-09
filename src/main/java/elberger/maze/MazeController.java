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

/*	public Cell startingCell()
	{
		Random x = new Random();
		Random y = new Random();
		Cell start = new Cell(x.nextInt(maxRows()), y.nextInt(maxCols()));
		return start;
	}*/
}