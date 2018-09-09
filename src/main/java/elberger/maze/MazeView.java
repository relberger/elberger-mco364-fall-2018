package elberger.maze;

public class MazeView
{
	public static void main(String args[])
	{
		MazeController controller = new MazeController();

		MazeModel model = new MazeModel(controller.maxRows(), controller.maxCols());
		//model.makePath(controller.startingCell());
	}
}
