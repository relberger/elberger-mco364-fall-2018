package elberger.mazeFromClass;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest
{

	@Test
	public void removeWalls_South()
	{
		Cell a = new Cell(1, 1);
		Cell b = new Cell(1, 2);

		a.removeWalls(b);

		assertFalse(a.isSouthWall());
		assertFalse(b.isNorthWall());
	}
	@Test
	public void removeWalls_North()
	{
		Cell a = new Cell(1, 1);
		Cell b = new Cell(1, 0);

		a.removeWalls(b);

		assertFalse(a.isNorthWall());
		assertFalse(b.isSouthWall());
	}
	@Test
	public void removeWalls_East()
	{
		Cell a = new Cell(1, 1);
		Cell b = new Cell(2, 1);

		a.removeWalls(b);

		assertFalse(a.isEastWall());
		assertFalse(b.isWestWall());
	}
	@Test
	public void removeWalls_West()
	{
		Cell a = new Cell(1, 1);
		Cell b = new Cell(0, 1);

		a.removeWalls(b);

		assertFalse(a.isWestWall());
		assertFalse(b.isEastWall());
	}
	@Test (expected = IllegalStateException.class)
	public void removeWalls_IllegalState()
	{
		Cell a = new Cell(1, 1);
		Cell b = new Cell(2, 2);

		a.removeWalls(b);
	}
}