package elberger.maze;

import java.util.Random;

public class MazeMain
{
	public static void main(String args[])
	{
/*		int max = 10;
		int min = 5;

		Random x = new Random();
		int row = x.nextInt((max - min) + min);
		Random y = new Random();
		int col = y.nextInt((max - min) + min);*/

		Maze maze = new Maze(2, 2);
		maze.searchPath();

		System.out.print(maze.toString());
	}
}
