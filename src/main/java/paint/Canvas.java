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
	private Tools tool = Tools.PENCIL;
	private final List<Shape> shapes = new ArrayList<>();
	private final List<List<Point>> lines = new ArrayList<>();
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

		if (tool == Tools.PENCIL)
		{
			for (List<Point> line : lines)
			{
				for (int i = 1; i < line.size(); i++)
				{
					Color colorLine = line.get(i).getColor();
					g.setColor(colorLine);
					g.drawLine(line.get(i).getX(), line.get(i).getY(),
							line.get(i - 1).getX(), line.get(i - 1).getY());
				}
			}
		}
		if (tool == Tools.RECTANGLE)
		{
			//rectangles.get(rectangles.size() - 1).add(new Rectangle(0, 0, color, 0, 0));
			//rectangles.get(rectangles.size() - 1).add(new Point(0, 0, color));
			for (List<Point> rectangle : rectangles)
			{
				for (int i = 1; i < rectangle.size(); i++)
				{
					Color colorRectangle = rectangle.get(i).getColor();
					g.setColor(colorRectangle);
					g.drawRect(rectangle.get(i).getX(), rectangle.get(i).getY(),
							(rectangle.get(i - 1).getX() - rectangle.get(i).getX()),
							(rectangle.get(i - 1).getY() - rectangle.get(i).getY()));
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
		if (tool == Tools.PENCIL)
		{
			lines.get(lines.size() - 1).add(new Point(event.getX(), event.getY(), color));
			repaint();
		}
		if (tool == Tools.RECTANGLE)
		{
			rectangles.get(rectangles.size() - 1).add(new Point(0, 0, color));
			rectangles.get(rectangles.size() - 1).add(new Point(event.getX(), event.getY(), color));
					/*Rectangle(event.getX(), event.getY(), color,
					(event.getX() - rectangles.size() - 2), (event.getY() - rectangles.size() - 2)));*/
			repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (tool == Tools.PENCIL)
		{
			lines.add(new ArrayList<>());
		}
		if (tool == Tools.RECTANGLE)
		{
			rectangles.add(new ArrayList<>());
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
		//Rectangle rectangle = new Rectangle(rectangles.get(rectangles.size() - 1).get());
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
