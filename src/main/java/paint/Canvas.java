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
					//rectangles.get(rectangles.size() - 1).add(new Rectangle(0, 0, color, 0, 0));
					//rectangles.get(rectangles.size() - 1).add(new Point(0, 0, color));
					/*for (List<Point> rectangle : rectangles)
					{
						for (int i = 1; i < rectangle.size(); i++)
						{
							Color colorRectangle = rectangle.get(i).getColor();
							g.setColor(colorRectangle);
							g.drawRect(rectangle.get(i).getX(), rectangle.get(i).getY(),
									(rectangle.get(i - 1).getX() - rectangle.get(i).getX()),
									(rectangle.get(i - 1).getY() - rectangle.get(i).getY()));
						}
					}*/
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
			for (int i = 0; i < shapes.size(); i++)
			{
				if (tool == Tools.PENCIL)
				{
					ArrayList<Point> pencilPoints = ((Pencil) shapes.get(i)).getPoints();
					Point point = new Point(event.getX(), event.getY());
					pencilPoints.add(point);
					repaint();
				}
				if (tool == Tools.RECTANGLE)
				{
					rectangles.get(rectangles.size() - 1).add(new Point(0, 0));
					rectangles.get(rectangles.size() - 1).add(new Point(event.getX(), event.getY()));
					Rectangle(event.getX(), event.getY(), color,
					(event.getX() - rectangles.size() - 2), (event.getY() - rectangles.size() - 2)));
					repaint();
				}
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
		}
		if (tool == Tools.RECTANGLE)
		{
			Rectangle rectangle = new Rectangle(e.getX(), e.getY(), color);
			shapes.add(rectangle);
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
