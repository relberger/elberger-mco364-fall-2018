package elberger.maze;

public class MazeCell
{
	private int x;
	private int y;
	private boolean visited;

	public MazeCell(int x, int y, boolean visited)
	{
		this.x = x;
		this.y = y;
		this.visited = visited;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public boolean isVisited()
	{
		return visited;
	}

	public void setVisited(boolean visited)
	{
		this.visited = visited;
	}

}
