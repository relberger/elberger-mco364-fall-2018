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
		for (int i = 1; i < erasers.size(); i++)
		{
			g.fillRect(erasers.get(i).getX(), erasers.get(i).getY(),
					(erasers.get(i - 1).getX() - erasers.get(i).getX()) * 2,
					(erasers.get(i - 1).getY() - erasers.get(i).getY()) * 2);
		}
	}
}