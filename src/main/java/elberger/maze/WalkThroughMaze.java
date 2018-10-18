package elberger.maze;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class WalkThroughMaze extends KeyAdapter
{
	private Cell cell;
	private Maze maze;
	private Image playerImage;
	private Graphics g;

	@Override
	public void keyPressed(KeyEvent key)
	{
		startCell(g);

		if(key.getKeyCode() == KeyEvent.VK_UP && cell.getY() != 0)
		{
			goUp(g);
		}
		if(key.getKeyCode() == KeyEvent.VK_DOWN && cell.getY() != maze.getHeight())
		{
			goDown(g);
		}
		if(key.getKeyCode() == KeyEvent.VK_LEFT && cell.getX() != 0)
		{
			goLeft(g);
		}
		if(key.getKeyCode() == KeyEvent.VK_RIGHT && cell.getX() != maze.getWidth())
		{
			goRight(g);
		}
	}

	private Image makeImage()
	{
		try
		{
			playerImage = ImageIO.read(new File("elberger/maze/player.jpg"));
		} catch (IOException e2)
		{
			e2.printStackTrace();
		}
		return playerImage;
	}

	private void startCell(Graphics g)
	{
		cell = new Cell(0,0);
		g.drawImage(makeImage(), 0, 0, null);
	}

	private void goUp(Graphics g)
	{
		g.drawImage(makeImage(), cell.getX(), cell.getY() + 1, null);
		cell = maze.getMaze()[cell.getX()][cell.getY() + 1];
	}

	private void goDown(Graphics g)
	{
		g.drawImage(makeImage(), cell.getX(), cell.getY() - 1, null);
		cell = maze.getMaze()[cell.getX()][cell.getY() - 1];
	}

	private void goLeft(Graphics g)
	{
		g.drawImage(makeImage(), cell.getX() - 1, cell.getY(), null);
		cell = maze.getMaze()[cell.getX() - 1][cell.getY()];
	}

	private void goRight(Graphics g)
	{
		g.drawImage(makeImage(), cell.getX() + 1, cell.getY(), null);
		cell = maze.getMaze()[cell.getX() + 1][cell.getY()];
	}
}
