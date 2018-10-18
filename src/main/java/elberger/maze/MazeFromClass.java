package elberger.maze;

import com.google.common.annotations.VisibleForTesting;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeFromClass
{
	private final int width;
	private final int height;

	@VisibleForTesting
	final CellFromClass[][] cells;

	public MazeFromClass(int width, int height)
	{
		this.width = width;
		this.height = height;
		cells = new CellFromClass[width][height];
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				cells[i][j] = new CellFromClass(i, j);
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
				CellFromClass cell = cells[i][j];
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

	public CellFromClass getCell(int column, int row)
	{
		return cells[column][row];
	}

	//returns a cell or returns null
	@Nullable
	public CellFromClass getUnvisitedNeighbor(int row, int column)
	{
		List<CellFromClass> list = getAllNotVisitedNeighbors(row, column);

		if(list.isEmpty())
		{
			return null;
		}

		Collections.shuffle(list);
		return list.get(0);
	}

	@VisibleForTesting
	List<CellFromClass> getAllNotVisitedNeighbors(int row, int column)
	{
		List<CellFromClass> list = new ArrayList<>();

		/*int column = cell.getX();
		int row = cell.getY();*/

		//north
		if(row >= 0 && !cells[column][row - 1].isVisited())
		{
			list.add(getCell(column, row - 1));
		}

		//south
		if(row >= height - 1 && !cells[column][row + 1].isVisited())
		{
			list.add(getCell(column, row + 1));
		}

		//west
		if(row >= height - 1 && !cells[column - 1][row].isVisited())
		{
			list.add(getCell(column - 1, row));
		}

		//east
		if(row >= height - 1 && !cells[column + 1][row].isVisited())
		{
			list.add(getCell(column + 1, row));
		}
		return list;
	}

	/*public MazeFromClass build()
	{
		return maze;
	}*/
}
