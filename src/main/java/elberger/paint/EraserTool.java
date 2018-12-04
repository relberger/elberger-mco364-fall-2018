package elberger.paint;

import java.awt.*;
import java.util.ArrayList;

public class EraserTool implements Tool
{
	private  Eraser eraser;

	public EraserTool()
	{

	}
	@Override
	public void onDrag(int x, int y)
	{
		eraser.getErasers().add(new Eraser(x, y, Color.white));
	}

	@Override
	public void onPress(int x, int y, Color color)
	{
		eraser = new Eraser(x, y, color);
		ArrayList<Eraser> erasers = new ArrayList<>();
		eraser.setErasers(erasers);
	}

	@Override
	public void onRelease(int x, int y)
	{

	}

	@Override
	public Shape getShape()
	{
		return null;
	}
}
