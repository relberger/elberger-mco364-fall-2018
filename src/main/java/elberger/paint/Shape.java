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

	public void paint(Graphics graphics)
	{
		graphics.setColor(color);
	}
}