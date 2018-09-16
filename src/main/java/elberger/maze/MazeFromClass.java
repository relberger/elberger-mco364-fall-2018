package elberger.maze;

public class MazeFromClass
{
	private final int width;
	private final int height;
	Cell[][] cells;

	public MazeFromClass(int width, int height)
	{
		this.width = width;
		this.height = height;
		cells = new Cell[width][height];
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				//cells[i][j] = new Cell(i, j);
			}
		}
	}

	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				Cell cell = cells[i][j];
				if (cell.isSouthWall())
				{
					builder.append("_");
				}
				if (cell.isEastWall())
				{
					builder.append("|");
				}
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
