package elberger.paint;

import java.awt.*;

public class FilledRectangle extends Rectangle
{
	public FilledRectangle(int x, int y, Color color)
	{
		super(x, y, color);
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		g.fillRect(getLeftX(), getTopY(), getWidth(), getHeight());
	}
}

