package elberger.paint;

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

		for (int i = 0; i < shapes.size(); i++)
		{
			g.setColor(shapes.get(i).getColor());
			if (shapes.get(i).getTool() == Tools.PENCIL)
			{
				drawPencil(g, i);
			}
			else if (shapes.get(i).getTool() == Tools.RECTANGLE)
			{
				drawRectangle(g, i);
			}
		}
	}

	private void drawCanvas(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	private void drawPencil(Graphics g, int i)
	{
		ArrayList<Point> pencilPoints = ((Pencil) shapes.get(i)).getPoints();
		for (int p = 1; p < pencilPoints.size(); p++)
		{
			g.drawLine(pencilPoints.get(p).getX(), pencilPoints.get(p).getY(),
					pencilPoints.get(p - 1).getX(), pencilPoints.get(p - 1).getY());
		}
	}

	private void drawRectangle(Graphics g, int i)
	{
		Rectangle rectangle = (Rectangle) shapes.get(i);
		g.drawRect(rectangle.getLeftX(), rectangle.getTopY(), rectangle.getWidth(), rectangle.getHeight());
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
			ArrayList<Point> pencilPoints = ((Pencil) shapes.get(current)).getPoints();
			Point point = new Point(event.getX(), event.getY());
			pencilPoints.add(point);
			repaint();
		}
		else if (tool == Tools.RECTANGLE)
		{
			((Rectangle) shapes.get(current)).setRightX(event.getX());
			((Rectangle) shapes.get(current)).setBottomY(event.getY());
			repaint();
		}
	}


	@Override
	public void mousePressed(MouseEvent e)
	{
		if (tool == Tools.PENCIL)
		{
			Pencil pencil = new Pencil(e.getX(), e.getY(), color);
			pencil.setTool(Tools.PENCIL);
			ArrayList<Point> pencilPoints = new ArrayList<>();
			pencil.setPoints(pencilPoints);
			shapes.add(pencil);
			current++;
		}
		else if (tool == Tools.RECTANGLE)
		{
			Rectangle rectangle = new Rectangle(e.getX(), e.getY(), color);
			rectangle.setTool(Tools.RECTANGLE);
			shapes.add(rectangle);
			current++;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (tool == Tools.RECTANGLE)
		{
			((Rectangle) shapes.get(current)).setRightX(e.getX());
			((Rectangle) shapes.get(current)).setBottomY(e.getY());
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
	public void mouseEntered(MouseEvent e)
	{

	}

	@Override
	public void mouseExited(MouseEvent e)
	{

	}
}
