package paint;

import java.awt.*;

public class Rectangle extends Shape
{
	private int width;
	private int height;

	public Rectangle(int x, int y, Color color, int width, int height)
	{
		super(x, y, color);
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
}
