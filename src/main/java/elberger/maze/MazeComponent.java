package elberger.maze;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MazeComponent extends JComponent
{
	private Maze maze;
	private int cellWidth;
	private int cellHeight;

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);

		maze = new Maze(20, 15);
		maze.searchPath();

		drawMaze(g);
	}

	public void drawMaze(Graphics g)
	{
		cellWidth = 500 / maze.getWidth();
		cellHeight = 500 / maze.getHeight();

		for (int x = 0; x < maze.getWidth(); x++)
		{
			for (int y = 0; y < maze.getHeight(); y++)
			{
				Cell cell = maze.getMaze()[x][y];
				if (cell.isSouthWall())
				{
					g.drawLine(x * cellWidth, y * cellHeight + cellHeight, x * cellWidth + cellWidth, y * cellHeight + cellHeight);
				}
				if (cell.isEastWall())
				{
					g.drawLine(x * cellWidth + cellWidth, y * cellHeight, x * cellWidth + cellWidth, y * cellHeight + cellHeight);
				}
				if (cell == maze.getMaze()[19][14])
				{
					g.drawString("End", 477, 490);
				}
			}
		}
	}
}
