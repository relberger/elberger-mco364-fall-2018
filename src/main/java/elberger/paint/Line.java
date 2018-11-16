package elberger.paint;

import java.awt.*;
import java.util.ArrayList;

public class Line extends Shape
{
	private ArrayList<Point> points;

	public Line(int x, int y)
	{
		super(x, y);
	}

	public ArrayList<Point> getPoints()
	{
		return points;
	}

	public void setPoints(ArrayList<Point> points)
	{
		this.points = points;
	}
}
