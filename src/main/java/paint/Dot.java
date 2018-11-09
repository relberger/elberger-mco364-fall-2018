package paint;

import java.awt.*;

public class Dot
{
	final int x;
	final int y;
	final Color color;

	public Dot(int x, int y, Color color)
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
}
