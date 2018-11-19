package elberger.paint;

import java.awt.*;

public abstract class Shape
{
	private int x;
	private int y;
	private Color color;

	public Shape(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public void paint(Graphics graphics)
	{
		graphics.setColor(getColor());
	}
}