package elberger.maze;

import java.util.Random;

public class MazeMain
{
	public static void main(String args[])
	{
/*		int max = 4;
		int min = 2;

		Random x = new Random();
		int row = x.nextInt((max - min) + min);
		Random y = new Random();
		int col = y.nextInt((max - min) + min);*/

		Maze maze = new Maze(2, 2);

		maze.toString();
	}
}
