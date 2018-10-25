package elberger.mazeFromClass;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MazeTest
{

	@Test
	public void testToString_blank()
	{
		// given
		Maze maze = new Maze(2, 2);

		// when
		String s = maze.toString();

		// then
		Assert.assertEquals(
				"_|_|\n" +
						"_|_|\n", s);
	}

	@Test
	public void testToString_noInnerWalls()
	{
		// given
		Maze maze = new Maze(2, 2);
		maze.cells[0][0].setSouthWall(false);
		maze.cells[0][0].setEastWall(false);

		maze.cells[1][0].setSouthWall(false);
		maze.cells[1][0].setEastWall(true);

		maze.cells[0][1].setSouthWall(true);
		maze.cells[0][1].setEastWall(false);

		maze.cells[1][1].setSouthWall(true);
		maze.cells[1][1].setEastWall(true);

		// when
		String s = maze.toString();

		// then
		Assert.assertEquals(
				"   |\n" +
						"_ _|\n", s);
	}

	@Test
	public void testGetAllNotVisitedNeighbors_allNeighborsNotVisited()
	{

		// given
		Maze maze = new Maze(3, 3);

		// when
		List<Cell> neighbors = maze.getAllNotVisitedNeighbors(1, 1);

		// then
		assertEquals(4, neighbors.size());
		assertEquals(neighbors.get(0), maze.getCell(1, 0));
		assertEquals(neighbors.get(1), maze.getCell(1, 2));
		assertEquals(neighbors.get(2), maze.getCell(0, 1));
		assertEquals(neighbors.get(3), maze.getCell(2, 1));
	}

	@Test
	public void testGetNotVisitedNeighbor_allNeighborsNotVisited()
	{

		// given
		Maze maze = new Maze(3, 3);

		// when
		Cell neighbor = maze.getNotVisitedNeighbor(1, 1);

		// then
		assertNotNull(neighbor);
		assertFalse(neighbor.isVisited());
		int x = neighbor.getColumn();
		int y = neighbor.getRow();
		// (0,1), (1,0), (2,1), (1,2)
		List<Cell> possibilities = new ArrayList<>();
		possibilities.add(maze.getCell(0, 1));
		possibilities.add(maze.getCell(1, 0));
		possibilities.add(maze.getCell(2, 1));
		possibilities.add(maze.getCell(1, 2));
		assertTrue(possibilities.contains(neighbor));
	}

	@Test
	public void testGetNotVisitedNeighbor_allNeighborsVisited()
	{

		// given
		Maze maze = new Maze(3, 3);
		maze.getCell(0, 1).setVisited(true);
		maze.getCell(1, 0).setVisited(true);
		maze.getCell(2, 1).setVisited(true);
		maze.getCell(1, 2).setVisited(true);

		// when
		Cell neighbor = maze.getNotVisitedNeighbor(1, 1);

		// then
		assertNull(neighbor);
	}

	@Test
	public void testGetNotVisitedNeighbor_noNeighbors()
	{

		// given
		Maze maze = new Maze(1, 1);

		// when
		Cell neighbor = maze.getNotVisitedNeighbor(0, 0);

		// then
		assertNull(neighbor);
	}
}