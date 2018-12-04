package elberger.paint;

import java.awt.*;

public class RectangleTool implements Tool
{
	private Rectangle rectangle;

	public RectangleTool()
	{
	}

	@Override
	public void onDrag(int x, int y)
	{
		rectangle.setRightX(x);
		rectangle.setBottomY(y);
	}

	@Override
	public void onPress(int x, int y, Color color)
	{
		rectangle = new Rectangle(x, y, color);//, color);
	}

	@Override
	public void onRelease(int x, int y)
	{
		rectangle.setRightX(x);
		rectangle.setBottomY(y);
	}

	@Override
	public Shape getShape()
	{
		return rectangle;
	}
}
