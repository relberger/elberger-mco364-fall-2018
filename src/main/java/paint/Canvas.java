package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JComponent implements MouseMotionListener, MouseListener
{
	private final List<List<Point>> lines = new ArrayList<>();

	public Canvas()
	{
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawCanvas(g);

		g.setColor(Color.black);

		for (List<Point> line : lines)
		{
			for (int i = 1; i < line.size(); i++)
			{
				g.drawLine(line.get(i).getX(), line.get(i).getY(),
						line.get(i - 1).getX(), line.get(i - 1).getY());
			}
		}

	}

	public void drawCanvas(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

	@Override
	public void mouseDragged(MouseEvent event)
	{
		lines.get(lines.size() - 1).add(new Point(event.getX(), event.getY()));
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{

	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		lines.add(new ArrayList<>());

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}
}
