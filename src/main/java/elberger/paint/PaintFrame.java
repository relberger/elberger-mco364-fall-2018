package elberger.paint;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PaintFrame extends JFrame
{
	private Canvas canvas;
	private JButton chooseColor;
	private JButton choosePencil;
	private JButton chooseRectangle;
	private JButton chooseEraser;
	private JButton chooseFilledRectangle;
	private JButton chooseUndo;
	private JButton chooseSaveAsPNG;
	private JButton chooseSaveAsShapes;
	private JButton chooseOpenAsShapes;
	private Color color;

	public PaintFrame()
	{
		setTitle("Paint");
		setSize(1200, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();

		chooseColor = new JButton("Choose Color");
		choosePencil = new JButton("Line");
		chooseRectangle = new JButton("Rectangle");
		chooseEraser = new JButton("Eraser");
		chooseFilledRectangle = new JButton("Filled Rectangle");
		chooseUndo = new JButton("Undo");
		chooseSaveAsPNG = new JButton("Save as PNG");
		chooseSaveAsShapes = new JButton("Save as Shapes");
		chooseOpenAsShapes = new JButton("Open as Shapes");

		buttonPanel.add(chooseColor);
		buttonPanel.add(choosePencil);
		buttonPanel.add(chooseRectangle);
		buttonPanel.add(chooseEraser);
		buttonPanel.add(chooseFilledRectangle);
		buttonPanel.add(chooseUndo);
		buttonPanel.add(chooseSaveAsPNG);
		buttonPanel.add(chooseSaveAsShapes);
		buttonPanel.add(chooseOpenAsShapes);

		chooseColor.addActionListener(actionEvent ->
		{
			color = JColorChooser.showDialog(PaintFrame.this, "Choose Color", canvas.getColor());
			canvas.setColor(color);
		});

		choosePencil.addActionListener(actionEvent -> canvas.setTool(new PencilTool()));

		chooseRectangle.addActionListener(actionEvent -> canvas.setTool(new RectangleTool()));

		chooseEraser.addActionListener(actionEvent -> canvas.setTool(new EraserTool()));

		chooseFilledRectangle.addActionListener(actionEvent -> canvas.setTool(new FilledRectangleTool()));

		chooseUndo.addActionListener(actionEvent -> canvas.undo());

		chooseSaveAsPNG.addActionListener(actionEvent ->
		{
			try
			{
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showSaveDialog(this);
				canvas.setPNGFile(fileChooser.getSelectedFile());
				canvas.saveAsPNG();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});

		chooseSaveAsShapes.addActionListener(actionEvent ->
		{
			try
			{
				canvas.saveAsShapes();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});

		chooseOpenAsShapes.addActionListener(actionEvent ->
		{
			try
			{
				canvas.openAsShapes();
			} catch (IOException e)
			{
				e.printStackTrace();
			} catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		});

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
