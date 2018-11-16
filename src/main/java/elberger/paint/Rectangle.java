package elberger.paint;

import java.awt.*;

public class Rectangle extends Shape
{
	private int width;
	private int height;
	private int rightX;
	private int bottomY;
	private int leftX;
	private int topY;

	public Rectangle(int x, int y)
	{
		super(x, y);
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

	public int getRightX()
	{
		return rightX;
	}

	public void setRightX(int rightX)
	{
		this.rightX = rightX;
		setLeftX();
		setWidth(Math.abs(getLeftX() - getRightX()));
	}

	public int getBottomY()
	{
		return bottomY;
	}

	public void setBottomY(int bottomY)
	{
		this.bottomY = bottomY;
		setTopY();
		setHeight(Math.abs(getBottomY() - getTopY()));
	}

	public int getLeftX()
	{
		return leftX;
	}

	public void setLeftX()
	{
		if (getX() <= rightX)
		{
			leftX = getX();
		}
		else
		{
			leftX = rightX;
			rightX = getX();
		}
	}

	public int getTopY()
	{
		return topY;
	}

	public void setTopY()
	{
		if (getY() <= bottomY)
		{
			topY = getY();
		}
		else
		{
			topY = bottomY;
			bottomY = getY();
		}
	}
}
