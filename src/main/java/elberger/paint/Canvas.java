package elberger.paint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Canvas extends JComponent implements MouseMotionListener, MouseListener
{
	private Tool tool = new PencilTool();
	private final List<Shape> shapes = new ArrayList<>();
	private Color color = Color.BLACK;
	private File userFilePNG;
	private String userFileShapes;

	public Canvas()
	{
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		drawCanvas(g);

		for (Shape shape : shapes)
		{
			g.setColor(shape.getColor());
			shape.paint(g);
		}
	}

	private void drawCanvas(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	public Color getColor()
	{
		return color;
	}

	public void setTool(Tool tool)
	{
		this.tool = tool;
	}

	public void undo()
	{
		if (!shapes.isEmpty())
		{
			shapes.remove(shapes.size() - 1);
			repaint();
		}
	}

	public void saveAsPNG() throws IOException
	{
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();

		drawCanvas(g2d);
		for (Shape shape : shapes)
		{
			g2d.setColor(shape.getColor());
			shape.paint(g2d);
		}

		File filePNG = new File(userFilePNG.getAbsolutePath() + ".png");
		ImageIO.write(bufferedImage, "png", filePNG);
	}

	public void setUserFilePNG(File userFilePNG)
	{
		this.userFilePNG = userFilePNG;
	}

	public void saveAsShapes() throws IOException
	{
		FileOutputStream fileOutputStream = new FileOutputStream(userFileShapes);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		objectOutputStream.writeObject(shapes);

		objectOutputStream.close();
	}

	public void openAsShapes() throws IOException, ClassNotFoundException
	{
		FileInputStream fileInputStream = new FileInputStream(userFileShapes);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		Object readShapes = objectInputStream.readObject();
		shapes.clear();
		shapes.addAll((List<Shape>) readShapes);
		objectInputStream.close();

		repaint();
	}

	public void setUserFileShapes(String userFileShapes)
	{
		this.userFileShapes = userFileShapes;
	}

	@Override
	public void mouseDragged(MouseEvent event)
	{
		tool.onDrag(event.getX(), event.getY());
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		tool.onPress(e.getX(), e.getY(), color);
		shapes.add(tool.getShape());
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		tool.onRelease(e.getX(), e.getY());
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}
}
