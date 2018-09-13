package elberger.maze;

import java.util.Random;

public class MazeMain
{
	public static void main(String args[])
	{
		int max = 15;

		Random x = new Random();
		int row = x.nextInt(max);
		Random y = new Random();
		int col = y.nextInt(max);

		Maze maze = new Maze(row, col);
		maze.fillAllMazeCells();
		maze.generatePath();
		System.out.print(maze.toString());
	}
}
