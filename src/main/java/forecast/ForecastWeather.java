package forecast;

public class ForecastWeather
{
	private String description;
	private String icon;
	
	public ForecastWeather(String description, String icon)
	{
		super();
		this.description = description;
		this.icon = icon;
	}

	public String getDescription()
	{
		return description;
	}

	public String getIcon()
	{
		return icon;
	}
}
