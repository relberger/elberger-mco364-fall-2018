package elberger.maze;

import org.junit.Assert;
import org.junit.Test;

public class MazeTest
{
	@Test
	public void TestToString_blank()
	{
		// given
		MazeFromClass maze = new MazeFromClass(2, 2);

		//when
		String s = maze.toString();

		//then
		Assert.assertEquals("_|_|\n_|_|\n", s);
	}

	@Test
	public void TestToString_noInnerWalls()
	{
		// given
		MazeFromClass maze = new MazeFromClass(2, 2);
		maze.cells[0][0].setSouthWall(false);
		maze.cells[0][0].setEastWall(false);
		maze.cells[1][0].setSouthWall(false);
		maze.cells[1][0].setEastWall(true);
		maze.cells[0][1].setSouthWall(true);
		maze.cells[0][1].setEastWall(false);
		maze.cells[1][1].setSouthWall(true);
		maze.cells[1][1].setEastWall(true);

		//when
		String s = maze.toString();

		//then
		Assert.assertEquals("  |\n__|\n", s);
	}
}
