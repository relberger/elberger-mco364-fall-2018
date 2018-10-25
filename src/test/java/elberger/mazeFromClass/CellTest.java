package elberger.mazeFromClass;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest
{

	@Test
	public void removeWalls()
	{
		Cell a = new Cell(0, 0);
		Cell b = new Cell(0, 1);

		a.removeWalls(b);

		assertFalse(a.isSouthWall());
		assertFalse(b.isNorthWall());
	}
}