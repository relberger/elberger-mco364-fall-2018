package paint;

import java.awt.*;

public class Rectangle extends Shape
{
	private int width;
	private int height;
	private int endX;
	private int endY;

	public Rectangle(int x, int y, Color color)
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

	public int getEndX()
	{
		return endX;
	}

	public void setEndX(int endX)
	{
		this.endX = endX;
	}

	public int getEndY()
	{
		return endY;
	}

	public void setEndY(int endY)
	{
		this.endY = endY;
	}
}
