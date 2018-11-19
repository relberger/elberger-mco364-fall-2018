package elberger.paint;

import java.awt.*;

interface Tool
{
	void onDrag(int x, int y);
	void onPress(int x, int y, Color color);
	void onRelease(int x, int y);
	Shape getShape();
}