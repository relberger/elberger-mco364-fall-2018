package forecast;

public class Forecast
{
	private ForecastWeather weather[];
	private ForecastMain main;
	private String dt_txt;

	public Forecast(String description, String icon, double temp_min, double temp_max)
	{
		for (int ii = 0; ii < weather.length; ii++)
		{
			weather[ii] = new ForecastWeather(description, icon);
		}
		main = new ForecastMain(temp_min, temp_max);
	}

	public ForecastWeather[] getWeather()
	{
		return weather;
	}
	
	public ForecastMain getMain()
	{
		return main;
	}

	public String getDt_txt()
	{
		return dt_txt;
	}
}
