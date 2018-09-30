package forecast;

public class ForecastMain
{
	private double temp_min;
	private double temp_max;
	
	public ForecastMain(double temp_min, double temp_max)
	{
		super();
		this.temp_min = temp_min;
		this.temp_max = temp_max;
	}
	
	public int getTemp_min()
	{
		return (int) Math.round(temp_min);
	}
	
	public int getTemp_max()
	{
		return (int) Math.round(temp_max);
	}
}
