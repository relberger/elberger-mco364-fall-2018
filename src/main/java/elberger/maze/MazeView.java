package elberger.maze;

import javax.swing.*;
import java.awt.*;

public class MazeView extends JFrame
{
	private MazeComponent mazeComponent;

	public MazeView()
	{
		setTitle("Maze");
		setSize(505, 525);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		mazeComponent = new MazeComponent();

		panel.add(mazeComponent, BorderLayout.CENTER);

		setContentPane(panel);

		addKeyListener(new WalkThroughMaze());
	}

	public static void main(String[] args)
	{
		new MazeView().setVisible(true);
	}
}
