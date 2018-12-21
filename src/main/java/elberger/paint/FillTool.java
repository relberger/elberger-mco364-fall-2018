package elberger.paint;

import java.awt.*;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Stack;

public class FillTool implements Tool
{
	private Fill fill;
	private BufferedImage bufferedImage;
	private Canvas canvas;

	public FillTool(Canvas canvas)
	{
		this.canvas = canvas;
	}

	@Override
	public void onDrag(int x, int y)
	{
	}

	@Override
	public void onPress(int x, int y, Color color)
	{
		bufferedImage = new BufferedImage(canvas.getWidth(), canvas.getWidth(), BufferedImage.TYPE_INT_RGB);
		int initialFillPointColor = bufferedImage.getRGB(x, y);

		findPointsToFill(x, y);

		fill = new Fill(x, y, color);
	}

	private void findPointsToFill(int x, int y)
	{
		Stack<Point> stack = new Stack<>();
		ArrayList<Point> checkedPoints = new ArrayList<>();
		Point point = new Point(x, y);

		stack.add(point);

		while (!stack.isEmpty())
		{
			point = stack.pop();
			checkedPoints.add(point);

			//Point neighbor =
		}
	}

	@Override
	public void onRelease(int x, int y)
	{
	}

	@Override
	public Shape getShape()
	{
		return fill;
	}
}
