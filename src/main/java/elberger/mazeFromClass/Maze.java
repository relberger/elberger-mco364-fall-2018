package elberger.mazeFromClass;

import com.google.common.annotations.VisibleForTesting;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Maze
{

	private final int columns;
	private final int rows;

	@VisibleForTesting
	final Cell cells[][];

	public Maze(int columns, int rows)
	{
		this.columns = columns;
		this.rows = rows;
		cells = new Cell[columns][rows];

		for (int c = 0; c < columns; c++)
		{
			for (int r = 0; r < rows; r++)
			{
				cells[c][r] = new Cell(c, r);
			}
		}
	}

	public String toString()
	{
		StringBuilder builder = new StringBuilder();

		for (int c = 0; c < columns; c++)
		{
			for (int r = 0; r < rows; r++)
			{
				Cell cell = cells[r][c];
				builder.append(cell);
			}
			builder.append("\n");
		}

		return builder.toString();
	}

	public Cell getCell(int column, int row)
	{
		return cells[column][row];
	}

	public boolean isNotVisited(int column, int row)
	{
		return !getCell(column, row).isVisited();
	}

	@Nullable
	public Cell getNotVisitedNeighbor(int column, int row)
	{
		List<Cell> list = getAllNotVisitedNeighbors(column, row);

		if (list.isEmpty())
		{
			return null;
		}

		Collections.shuffle(list);
		return list.get(0);
	}

	@VisibleForTesting
	List<Cell> getAllNotVisitedNeighbors(int column, int row)
	{
		List<Cell> list = new ArrayList<>();

		// NORTH
		if (row > 0 && isNotVisited(column, row - 1))
		{
			list.add(getCell(column, row - 1));
		}
		// SOUTH
		if (row < rows - 1 && isNotVisited(column, row + 1))
		{
			list.add(getCell(column, row + 1));
		}
		// WEST
		if (column > 0 && isNotVisited(column - 1, row))
		{
			list.add(getCell(column - 1, row));
		}
		// EAST
		if (column < columns - 1 && isNotVisited(column + 1, row))
		{
			list.add(getCell(column + 1, row));
		}
		return list;
	}
}