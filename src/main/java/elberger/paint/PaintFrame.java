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

		chooseColor.addActionListener(actionEvent ->
		{
			color = JColorChooser.showDialog(PaintFrame.this, "Choose Color", canvas.getColor());
			canvas.setColor(color);
		});

		choosePencil.addActionListener(actionEvent -> canvas.setTool(Tools.PENCIL));

		chooseRectangle.addActionListener(actionEvent -> canvas.setTool(Tools.RECTANGLE));

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
