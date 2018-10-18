package elberger.maze;

import javax.swing.*;
import java.awt.*;

public class MazeComponent extends JComponent
{
	private Maze maze;
	private Player player;
	private int cellWidth;
	private int cellHeight;

	public MazeComponent(Maze maze, Player player)
	{
		this.maze = maze;
		this.player = player;
	}

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.black);

		drawMaze(g);
		drawPlayer(g, 0, 0);
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

	public void drawPlayer(Graphics g, int x, int y)
	{
		g.setColor(Color.ORANGE);
		g.fillRect(player.getX(), player.getY(), getWidth()/maze.getWidth(), getHeight()/maze.getHeight());
	}

	public Player getPlayer()
	{
		return player;
	}
}
