package elberger.paint;

import java.awt.*;

interface Tool
{
	void onDrag(int x, int y);
	void onPress(int x, int y);
	void onRelease(int x, int y);
	Class<Rectangle> getShape();
	void drawShape(Graphics graphics);
}