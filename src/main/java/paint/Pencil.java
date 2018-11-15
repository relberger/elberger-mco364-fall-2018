package paint;

import java.awt.*;
import java.util.ArrayList;

public class Pencil extends Shape
{
	private ArrayList<Point> points;

	public Pencil(int x, int y, Color color)
	{
		super(x, y, color);
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
