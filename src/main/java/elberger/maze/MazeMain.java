package elberger.maze;

import java.util.Random;

public class MazeMain
{
	public static void main(String args[])
	{
		int max = 4;
		int min = 2;

		Random x = new Random();
		int row = x.nextInt((max - min) + min);
		Random y = new Random();
		int col = y.nextInt((max - min) + min);

		Maze maze = new Maze(row, col);

		maze.displayMaze();

//		maze.generatePath();

/*		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				System.out.print(maze[i][j]);
			}
		}*/

		//System.out.print(maze.toString());
	}
}
