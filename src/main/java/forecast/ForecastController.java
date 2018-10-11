package forecast;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;

public class ForecastController
{
	private ForecastView view;
	private ForecastService service;
	private List<WeatherPanel> weatherPanels;
	Disposable disposable;
	private ForecastFeedModel feed;

	public ForecastController(ForecastView view, ForecastService service)
	{
		super();
		this.view = view;
		this.service = service;
		this.weatherPanels = view.getWeatherPanels();
	}
	
	public void requestForecastFeed()
	{
		disposable = Observable
				.interval(0, 5, TimeUnit.SECONDS)
				.flatMap(forecast -> service.getWeatherByZip(view.getUserZip().trim()))
				.map(feed -> feed.getList())
				.subscribeOn(Schedulers.io())
				.observeOn(Schedulers.single())
				.subscribe(this::showForecast, throwable -> view.invalidZipDialog());
	}

	public void requestForecast()
	{
		requestForecastFeed();
	}

	private void showForecast(List<Forecast> list) throws MalformedURLException
	{
		for(int ix = 0; ix < weatherPanels.size(); ix++)
		{
			List<Forecast> info = list
								.stream()
								.collect(Collectors.toList());
			
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
			
			weatherPanels.get(ix).getHigh().setText("High: " + String.valueOf(forecast.getMain().getTemp_max()) + "°F");
			
			weatherPanels.get(ix).getLow().setText("Low: " + String.valueOf(forecast.getMain().getTemp_min()) + "°F");
		}
	}

	public void stop()
	{
		disposable.dispose();
	}
}
