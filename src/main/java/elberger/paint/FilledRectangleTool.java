package elberger.paint;

import java.awt.*;

public class FilledRectangleTool implements Tool
{
	private FilledRectangle filledRectangle;

	public FilledRectangleTool()
	{

	}
	@Override
	public void onDrag(int x, int y)
	{
		filledRectangle.setRightX(x);
		filledRectangle.setBottomY(y);
	}

	@Override
	public void onPress(int x, int y, Color color)
	{
		filledRectangle  = new FilledRectangle(x, y, color);
	}

	@Override
	public void onRelease(int x, int y)
	{
		filledRectangle.setRightX(x);
		filledRectangle.setBottomY(y);
	}

	@Override
	public Shape getShape()
	{
		return filledRectangle;
	}
}
