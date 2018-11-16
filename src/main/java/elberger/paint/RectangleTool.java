package elberger.paint;

import java.awt.*;
import java.util.List;

public class RectangleTool implements Tool
{
	private Rectangle rectangle;
	private List<Shape> shapes;

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
	public void onPress(int x, int y)
	{
		rectangle = new Rectangle(x, y);
		shapes.add(rectangle);
	}

	@Override
	public void onRelease(int x, int y)
	{
		rectangle.setRightX(x);
		rectangle.setBottomY(y);
	}

	@Override
	public Class<Rectangle> getShape()
	{
		return Rectangle.class;
	}


	@Override
	public void drawShape(Graphics graphics)
	{
		graphics.drawRect(rectangle.getLeftX(), rectangle.getTopY(), rectangle.getWidth(), rectangle.getHeight());
	}
}
