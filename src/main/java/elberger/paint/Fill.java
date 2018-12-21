package elberger.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Fill extends Shape
{
	private Point center;

	public Fill(int x, int y, Color color)
	{
		super(x, y, color);
	}

	@Override
	public void paint(BufferedImage bufferedImage, Graphics imageGraphics)
	{
		super.paint(bufferedImage, imageGraphics);
	}
}
