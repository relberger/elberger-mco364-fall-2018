package elberger.paint;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PencilTool implements Tool
{
	private Line line;
	//private List<Shape> shapes;

	public PencilTool()
	{

	}

	@Override
	public void onDrag(int x, int y)
	{
		line.getPoints().add(new Point(x, y));
	}

	@Override
	public void onPress(int x, int y)
	{
		line = new Line(x, y);
		ArrayList<Point> pencilPoints = new ArrayList<>();
		line.setPoints(pencilPoints);
		//shapes.add(line);
	}

	@Override
	public void onRelease(int x, int y)
	{

	}

	@Override
	public List<Shape> getShapes(List<Shape> shapes)
	{
		return shapes;
	}

	@Override
	public void drawShape(Graphics graphics)
	{
		ArrayList<Point> pencilPoints = line.getPoints();
		for (int i = 1; i < pencilPoints.size(); i++)
		{
			graphics.drawLine(pencilPoints.get(i).getX(), pencilPoints.get(i).getY(),
					pencilPoints.get(i - 1).getX(), pencilPoints.get(i - 1).getY());
		}
	}
}
