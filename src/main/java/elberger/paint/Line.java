package elberger.paint;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Line extends Shape
{
	private ArrayList<Point> points;

	public Line(int x, int y, Color color)
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

	@Override
	public void paint(BufferedImage bufferedImage, Graphics imageGraphics)
	{
		super.paint(bufferedImage, imageGraphics);
		ArrayList<Point> pencilPoints = getPoints();
		for (int i = 1; i < pencilPoints.size(); i++)
		{
			imageGraphics.drawLine(pencilPoints.get(i).getX(), pencilPoints.get(i).getY(),
					pencilPoints.get(i - 1).getX(), pencilPoints.get(i - 1).getY());
		}
	}
}
