package elberger.paint;

import java.awt.*;
import java.util.ArrayList;

public class Line extends Shape
{
	private ArrayList<Point> points;

	public Line(int x, int y, Color color)
	{
		super(x, y);
		setColor(color);
	}

	public ArrayList<Point> getPoints()
	{
		return points;
	}

	public void setPoints(ArrayList<Point> points)
	{
		this.points = points;
	}

	@Override
	public void paint(Graphics g)
	{
		ArrayList<Point> pencilPoints = getPoints();
		for (int i = 1; i < pencilPoints.size(); i++)
		{
			g.drawLine(pencilPoints.get(i).getX(), pencilPoints.get(i).getY(),
					pencilPoints.get(i - 1).getX(), pencilPoints.get(i - 1).getY());
		}
	}
}
