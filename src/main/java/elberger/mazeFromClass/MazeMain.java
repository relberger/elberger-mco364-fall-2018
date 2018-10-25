package elberger.mazeFromClass;

public class MazeMain
{

	public static void main(String args[])
	{
		Maze maze = new MazeBuilder(5, 5)
				.randomize()
				.build();

		System.out.println(maze.toString());
	}

}