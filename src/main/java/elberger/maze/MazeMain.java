package elberger.maze;

public class MazeMain
{
	public static void main(String args[])
	{
		Maze maze = new Maze(10, 10);
		maze.searchPath();

		System.out.print(maze.toString());
	}
}
