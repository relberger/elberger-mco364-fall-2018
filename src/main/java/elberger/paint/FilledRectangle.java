package elberger.paint;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FilledRectangle extends Rectangle
{
	public FilledRectangle(int x, int y, Color color)
	{
		super(x, y, color);
	}

	@Override
	public void paint(BufferedImage bufferedImage, Graphics imageGraphics)
	{
		super.paint(bufferedImage, imageGraphics);
		imageGraphics.fillRect(getLeftX(), getTopY(), getWidth(), getHeight());
	}
}

