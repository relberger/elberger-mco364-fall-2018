package paint;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JComponent implements MouseMotionListener, MouseListener
{
	private Tools tool = Tools.PENCIL;
	private final List<Shape> shapes = new ArrayList<>();
	private final List<List<Point>> rectangles = new ArrayList<>();
	private Color color = Color.BLACK;
	private int current = -1;

	public Canvas()
	{
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		drawCanvas(g);

		if (!shapes.isEmpty())
		{
			for (int i = 0; i < shapes.size(); i++)
			{
				if (tool == Tools.PENCIL)
				{
					ArrayList<Point> pencilPoints = ((Pencil) shapes.get(i)).getPoints();
					for (int p = 1; p < pencilPoints.size(); p++)
					{
						g.setColor(shapes.get(i).getColor());
						g.drawLine(pencilPoints.get(p).getX(), pencilPoints.get(p).getY(),
								pencilPoints.get(p - 1).getX(), pencilPoints.get(p - 1).getY());
					}
				}
				if (tool == Tools.RECTANGLE)
				{
					Rectangle rectangle = (Rectangle) shapes.get(i);
					g.drawRect(rectangle.getX(), rectangle.getY(),
							(rectangle.getX() - rectangle.getEndX()), (rectangle.getY() - rectangle.getEndY()));
				}
			}
		}
	}


	public void drawCanvas(Graphics g)
	{
		g.setColor(Color.white);
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public Color getColor()
	{
		return color;
	}

	public void setTool(Tools tool)
	{
		this.tool = tool;
	}

	@Override
	public void mouseDragged(MouseEvent event)
	{
		if (!shapes.isEmpty())
		{
			if (tool == Tools.PENCIL)
			{
				ArrayList<Point> pencilPoints = ((Pencil) shapes.get(current)).getPoints();
				Point point = new Point(event.getX(), event.getY());
				pencilPoints.add(point);
				repaint();
			}
			if (tool == Tools.RECTANGLE)
			{
				((Rectangle) shapes.get(current)).setEndX(event.getX());
				((Rectangle) shapes.get(current)).setEndY(event.getY());
				repaint();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (tool == Tools.PENCIL)
		{
			Pencil pencil = new Pencil(e.getX(), e.getY(), color);
			ArrayList<Point> pencilPoints = new ArrayList<>();
			pencil.setPoints(pencilPoints);
			shapes.add(pencil);
			current++;
		}
		if (tool == Tools.RECTANGLE)
		{
			Rectangle rectangle = new Rectangle(e.getX(), e.getY(), color);
			shapes.add(rectangle);
			current++;
		}
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
	public void mouseReleased(MouseEvent e)
	{
		if (tool == Tools.RECTANGLE)
		{
			((Rectangle) shapes.get(current)).setEndX(e.getX());
			((Rectangle) shapes.get(current)).setEndY(e.getY());
			repaint();
		}
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
