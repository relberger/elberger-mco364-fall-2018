package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Canvas extends JComponent implements MouseMotionListener
{
	public Canvas()
	{
		this.addMouseMotionListener(this);
	}

	public void paintComponent(Graphics g)
	{
		drawCanvas(g);
		scribble(g);
	}

	public void drawCanvas(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0,0,getWidth(),getHeight());
	}

	public void scribble(Graphics g)
	{
		g.setColor(Color.black);
		g.fillRect(getMousePosition().x, getMousePosition().y, 1, 1);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		ArrayList xLocations = new ArrayList();
		ArrayList yLocations = new ArrayList();
		xLocations.add(getMousePosition().x);
		yLocations.add(getMousePosition().y);

		repaint(((int) xLocations.get(0)), ((int)yLocations.get(0)), 1, 1);
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{

	}
}
