package elberger.paint;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PaintFrame extends JFrame
{
	private Canvas canvas;
	private Color color;
	private final String SAVE_PAINT_SHAPES_PATH = "src/main/java/elberger/paint/savedPaintShapes/";

	public PaintFrame()
	{
		setTitle("Paint");
		setSize(1200, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel buttonPanel = new JPanel();

		JButton chooseColor = new JButton("Choose Color");
		JButton choosePencil = new JButton("Line");
		JButton chooseRectangle = new JButton("Rectangle");
		JButton chooseEraser = new JButton("Eraser");
		JButton chooseFilledRectangle = new JButton("Filled Rectangle");
		JButton chooseUndo = new JButton("Undo");
		JButton chooseSaveAsPNG = new JButton("Save as PNG");
		JButton chooseSaveAsShapes = new JButton("Save as Shapes");
		JButton chooseOpenAsShapes = new JButton("Open as Shapes");
		JButton chooseFill = new JButton("Fill");

		buttonPanel.add(chooseColor);
		buttonPanel.add(choosePencil);
		buttonPanel.add(chooseRectangle);
		buttonPanel.add(chooseEraser);
		buttonPanel.add(chooseFilledRectangle);
		buttonPanel.add(chooseUndo);
		buttonPanel.add(chooseSaveAsPNG);
		buttonPanel.add(chooseSaveAsShapes);
		buttonPanel.add(chooseOpenAsShapes);
		buttonPanel.add(chooseFill);

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
				canvas.setUserFilePNG(fileChooser.getSelectedFile());
				canvas.saveAsPNG();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		});

		chooseSaveAsShapes.addActionListener(actionEvent ->
		{
			String saveAsShapesFile = JOptionPane.showInputDialog("Please enter a file name to save.");
			canvas.setUserFileShapes(SAVE_PAINT_SHAPES_PATH + saveAsShapesFile + ".ser");
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
			String openAsShapesFile = JOptionPane.showInputDialog("Please enter the file name you would like to open");
			canvas.setUserFileShapes(SAVE_PAINT_SHAPES_PATH + openAsShapesFile + ".ser");
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

		chooseFill.addActionListener(actionEvent -> canvas.setTool(new FillTool(canvas)));

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
