package elberger.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PaintFrame extends JFrame
{
	private Canvas canvas;
	private JButton chooseColor;
	private JButton choosePencil;
	private JButton chooseRectangle;
	private Color color;

	public PaintFrame()
	{
		setTitle("Paint");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();

		chooseColor = new JButton("Choose Color");
		choosePencil = new JButton("Pencil");
		chooseRectangle = new JButton("Rectangle");

		buttonPanel.add(chooseColor);
		buttonPanel.add(choosePencil);
		buttonPanel.add(chooseRectangle);

		ActionListener choosingColor = e ->
		{
			color = JColorChooser.showDialog(PaintFrame.this, "Choose Color", canvas.getColor());
			canvas.setColor(color);
		};
		chooseColor.addActionListener(choosingColor);

		ActionListener choosingPencil = e ->
		{
			canvas.setTool(Tools.PENCIL);
		};
		choosePencil.addActionListener(choosingPencil);

		ActionListener choosingRectangle = e ->
		{
			canvas.setTool(Tools.RECTANGLE);
		};
		chooseRectangle.addActionListener(choosingRectangle);

		canvas = new Canvas();

		panel.add(buttonPanel, BorderLayout.NORTH);
		panel.add(canvas, BorderLayout.CENTER);

		setContentPane(panel);
	}

	public static void main(String args[])
	{
		new PaintFrame().setVisible(true);
	}
}
