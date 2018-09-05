package elberger.maze;

import sun.awt.image.ImageWatched;

import java.util.*;

public class MazeModel
{
	private MazeController controller = new MazeController();
	private int x = controller.maxRows();
	private int y = controller.maxCols();
	private int maze[][];
	//private LinkedList<Integer> neighbors[];

	public MazeModel(int x, int y, int[][] maze)
	{
		this.x = x;
		this.y = y;
		this.maze = maze;
	}

	public LinkedList<Integer> findNeighbors(MazeCell cell)
	{
		LinkedList<Integer> neighbors;
		for (int i = 0; i < x; i++)
		{
			neighbors.add(cell.getX() + 1);
		}

		return neighbors;
	}
	public void searchPath(boolean visited[], int v)
	{
		MazeCell cell = controller.startingCell();



		// Mark the current node as visited
		visited[v] = true;

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = neighbors[v].listIterator();
		while (i.hasNext())
		{
			int n = i.next();
			if (!visited[n])
				searchPath(n, visited);
		}
	}

	// The function to do search traversal. It uses recursive searchPath()
	public void search(int v)
	{
		// Mark all the vertices as not visited(set as
		// false by default in java)
		//boolean visited[] = new boolean[V];

		// Call the recursive helper function to print search traversal
		//searchPath(v, visited);
	}

}
