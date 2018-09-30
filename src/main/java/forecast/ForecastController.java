package forecast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;

public class ForecastController
{
	private ForecastView view;
	private ForecastService service;
	private List<WeatherPanel> weatherPanels;
	
	public ForecastController(ForecastView view, ForecastService service)
	{
		super();
		this.view = view;
		this.service = service;
		this.weatherPanels = view.getWeatherPanels();
	}
	
	public void requestForecastFeed(Call <ForecastFeedModel> call)
	{
		call.enqueue(new Callback<ForecastFeedModel>()
				{
					@Override
					public void onResponse(Call <ForecastFeedModel> call, Response <ForecastFeedModel> response)
					{
						ForecastFeedModel feed = response.body();
						
						try
						{
							if(response.errorBody() != null)
							{
								view.invalidZipDialog();
							}
							else 
							{
								showForecast(feed);
							}
						} catch (MalformedURLException e)
						{
							e.printStackTrace();
						}
					}

					@Override
					public void onFailure(Call<ForecastFeedModel> call, Throwable t)
					{
						t.printStackTrace();						
					}
				});
	}
	
	public void requestForecast()
	{
		requestForecastFeed(service.getWeatherByZip(view.getUserZip().trim()));			
	}	
	
	void showForecast(ForecastFeedModel feed) throws MalformedURLException
	{
		for(int ix = 0; ix < weatherPanels.size(); ix++)
		{
			List<Forecast> info = feed.getList();
			
			Forecast forecast = info.get(ix);
			String timeStamp = forecast.getDt_txt();
			String timeStampSplit[] = timeStamp.split(" " , 2);
			String fullTime = timeStampSplit[1];
			String[] timeSplit = fullTime.split(":", 3); 
			int hour = Integer.parseInt(timeSplit[0]);
			if (hour == 12)
			{
				weatherPanels.get(ix).getTime().setText("12" + ":" + timeSplit[1] + " PM");						
			}
			else if (hour == 0)
			{
				weatherPanels.get(ix).getTime().setText("12" + ":" + timeSplit[1] + " AM");			
			}
			else if (hour < 12)
			{
				String hr = timeSplit[0];
				String[] hourSplit = hr.split("0", 2);
				weatherPanels.get(ix).getTime().setText(hourSplit[1] + ":" + timeSplit[1] + " AM");
			}
			else if (hour > 12)
			{
				int hr = Integer.parseInt(timeSplit[0]) - 12;
				timeSplit[0] = String.valueOf(hr);
				weatherPanels.get(ix).getTime().setText(timeSplit[0] + ":" + timeSplit[1] + " PM");
			}

			ForecastWeather weather[] = forecast.getWeather();
			
			URL iconUrl = new URL("http://openweathermap.org/img/w/" + weather[0].getIcon() + ".png");
			ImageIcon image = new ImageIcon(iconUrl);
			weatherPanels.get(ix).getIcon().setIcon(image);
			
			weatherPanels.get(ix).getDesc().setText(weather[0].getDescription());
			
			weatherPanels.get(ix).getHigh().setText("High: " + String.valueOf(forecast.getMain().getTemp_max()) + "�F");
			
			weatherPanels.get(ix).getLow().setText("Low: " + String.valueOf(forecast.getMain().getTemp_min()) + "�F");
		}
	}
}
