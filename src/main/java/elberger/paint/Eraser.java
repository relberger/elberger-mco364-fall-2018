package elberger.paint;

import java.awt.*;
import java.util.ArrayList;

public class Eraser extends Shape
{
	private ArrayList<Eraser> erasers;

	public Eraser(int x, int y, Color color)
	{
		super(x, y, Color.white);
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
		for (Eraser eraser : erasers)
		{
			g.fillRect(eraser.getX(), eraser.getY(), 10,10);
		}
	}
}