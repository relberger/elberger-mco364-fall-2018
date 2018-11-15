package paint;

import java.awt.*;

public class Shape
{
	private int x;
	private int y;
	private Color color;
	private Tools tool;

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

	public Tools getTool()
	{
		return tool;
	}

	public void setTool(Tools tool)
	{
		this.tool = tool;
	}
}