package elberger.paint;

import java.awt.*;
import java.util.ArrayList;

public class PencilTool implements Tool
{
	private Line line;

	public PencilTool()
	{

	}

	@Override
	public void onDrag(int x, int y)
	{
		line.getPoints().add(new Point(x, y));
	}

	@Override
	public void onPress(int x, int y, Color color)
	{
		line = new Line(x, y, color);
		ArrayList<Point> pencilPoints = new ArrayList<>();
		line.setPoints(pencilPoints);
	}

	@Override
	public void onRelease(int x, int y)
	{

	}

	@Override
	public Shape getShape()
	{
		return line;
	}
}
