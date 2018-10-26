package paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PaintFrame extends JFrame
{
	private Canvas canvas;

	public PaintFrame()
	{
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		canvas = new Canvas();

		panel.add(canvas, BorderLayout.CENTER);

		setContentPane(panel);
	}/*

	public class MouseMovement implements MouseMotionListener
	{
		@Override
		public void mouseDragged(MouseEvent e)
		{
			canvas.repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{
			//System.out.println(getMousePosition());
		}
	}*/

	public static void main(String args[])
	{
		new PaintFrame().setVisible(true);
	}
}
