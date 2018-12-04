package elberger.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintFrame extends JFrame
{
	private Canvas canvas;
	private JButton chooseColor;
	private JButton choosePencil;
	private JButton chooseRectangle;
	private JButton chooseEraser;
	private JButton chooseFilledRectangle;
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
		choosePencil = new JButton("Line");
		chooseRectangle = new JButton("Rectangle");
		chooseEraser = new JButton("Eraser");
		chooseFilledRectangle = new JButton("Filled Rectangle");


		buttonPanel.add(chooseColor);
		buttonPanel.add(choosePencil);
		buttonPanel.add(chooseRectangle);
		buttonPanel.add(chooseEraser);
		buttonPanel.add(chooseFilledRectangle);

		chooseColor.addActionListener(actionEvent ->
		{
			color = JColorChooser.showDialog(PaintFrame.this, "Choose Color", canvas.getColor());
			canvas.setColor(color);
		});

		choosePencil.addActionListener(actionEvent -> canvas.setTool(new PencilTool()));

		chooseRectangle.addActionListener(actionEvent -> canvas.setTool(new RectangleTool()));

		chooseEraser.addActionListener(actionEvent -> canvas.setTool(new EraserTool()));

		chooseFilledRectangle.addActionListener(actionEvent -> canvas.setTool(new FilledRectangleTool()));

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
