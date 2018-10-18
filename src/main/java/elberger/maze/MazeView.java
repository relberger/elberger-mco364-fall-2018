package elberger.maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazeView extends JFrame
{
	private MazeComponent mazeComponent;
	private Maze maze;
	private Player player;
	//private Graphics g;

	public MazeView()
	{
		setTitle("Maze");
		setSize(505, 525);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		maze = new Maze(20, 15);
		maze.searchPath();
		player = new Player(0, 0);
		mazeComponent = new MazeComponent(maze, player);

		panel.add(mazeComponent, BorderLayout.CENTER);

		addKeyListener(new WalkThroughMaze());

		setContentPane(panel);
	}

	public class WalkThroughMaze extends KeyAdapter
	{
		@Override
		public void keyPressed(KeyEvent key)
		{
			if (key.getKeyCode() == KeyEvent.VK_UP && player.getY() != 0)
			{
				goUp();
			}
			if (key.getKeyCode() == KeyEvent.VK_DOWN && player.getY() != maze.getHeight())
			{
				goDown();
			}
			if (key.getKeyCode() == KeyEvent.VK_LEFT && player.getX() != 0)
			{
				goLeft();
			}
			if (key.getKeyCode() == KeyEvent.VK_RIGHT && player.getX() != maze.getWidth())
			{
				goRight();
			}
		}

		private void goUp()
		{
			if (!maze.getMaze()[player.getX() / 25][player.getY() / 35].isNorthWall())
			{
				mazeComponent.getPlayer().setX(player.getX());
				mazeComponent.getPlayer().setY(player.getY() - (getHeight() / maze.getHeight()));
				mazeComponent.repaint();
			}
		}

		private void goDown()
		{
			if (!maze.getMaze()[player.getX() / 25][player.getY() / 35].isSouthWall())
			{
				mazeComponent.getPlayer().setX(player.getX());
				mazeComponent.getPlayer().setY(player.getY() + (getHeight() / maze.getHeight()));
				mazeComponent.repaint();
			}
		}

		private void goLeft()
		{
			if (!maze.getMaze()[player.getX() / 25][player.getY() / 35].isWestWall())
			{
				mazeComponent.getPlayer().setX(player.getX() - (getWidth() / maze.getWidth()));
				mazeComponent.getPlayer().setY(player.getY());
				mazeComponent.repaint();
			}
		}

		private void goRight()
		{
			if (!maze.getMaze()[player.getX() / 25][player.getY() / 35].isEastWall())
			{
				mazeComponent.getPlayer().setX(player.getX() + (getWidth() / maze.getWidth()));
				mazeComponent.getPlayer().setY(player.getY());
				mazeComponent.repaint();
			}
		}
	}

	public static void main(String[] args)
	{
		new MazeView().setVisible(true);
	}
}
