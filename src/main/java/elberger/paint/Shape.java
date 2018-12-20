package elberger.paint;

import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Serializable
{
	private int x;
	private int y;
	private Color color;

	public Shape(int x, int y, Color color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
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