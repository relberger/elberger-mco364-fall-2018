package forecast;

import java.util.List;

public class ForecastFeedModel
{
	private String cod;
	private List<Forecast> list;

	public ForecastFeedModel(String cod, List<Forecast> list)
	{
		this.cod = cod;
		this.list = list;
	}

	public String getCod()
	{
		return cod;
	}
	
	public List<Forecast> getList()
	{
		return list;
	}
}
