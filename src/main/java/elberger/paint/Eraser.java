package elberger.paint;

import java.awt.*;
import java.util.ArrayList;

public class Eraser extends Shape
{
	private int width;
	private int height;
	private ArrayList<Eraser> erasers;

	public Eraser(int x, int y, Color color)
	{
		super(x, y, color);
		setColor(Color.WHITE);
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

	public ArrayList<Eraser> getErasers()
	{
		return erasers;
	}

	public void setErasers(ArrayList<Eraser> erasers)
	{
		this.erasers = erasers;
	}

	@Override
	public void paint(Graphics g)
	{
		for (int i = 1; i < erasers.size(); i++)
		{
			setColor(Color.white);
			g.fillRect(erasers.get(i).getX(), erasers.get(i).getY(),
					(erasers.get(i - 1).getX() - erasers.get(i).getX()),
					(erasers.get(i - 1).getY() - erasers.get(i).getY()));
		}
	}
}