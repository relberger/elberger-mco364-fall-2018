package elberger.earthquake.net;

import java.util.Comparator;
import java.util.Optional;

import javax.swing.text.JTextComponent;

import com.google.inject.Inject;

import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeedModel;
import elberger.earthquake.EarthquakeProperties;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EarthquakeController
{
	private EarthquakeView view;
	private UsgsEarthquakeService service;

	@Inject
	public EarthquakeController(EarthquakeView view, UsgsEarthquakeService service)
	{
		this.view = view;
		this.service = service;
	}

	public void refreshData()
	{
		requestMonth();
		requestWeek();
		requestDay();
		requestHour();
	}

	public void requestEarthquakeFeed(Call<EarthquakeFeedModel> call, JTextComponent magnitudeField,
			JTextComponent locationField)
	{
		call.enqueue(new Callback<EarthquakeFeedModel>()
		{
			@Override
			public void onResponse(Call<EarthquakeFeedModel> call, Response<EarthquakeFeedModel> response)
			{
				EarthquakeFeedModel feed = response.body();

				showLargestEarthquake(feed, locationField, magnitudeField);
			}

			@Override
			public void onFailure(Call<EarthquakeFeedModel> callMonth, Throwable t)
			{
				t.printStackTrace();
			}
		});
	}

	public void requestMonth()
	{
		requestEarthquakeFeed(service.getAllMonth(), view.getMonthMagTextField(), view.getMonthLocTextField());
	}

	public void requestWeek()
	{
		requestEarthquakeFeed(service.getAllWeek(), view.getWeekMagTextField(), view.getWeekLocTextField());
	}

	public void requestDay()
	{
		requestEarthquakeFeed(service.getAllDay(), view.getDayMagTextField(), view.getDayLocTextField());
	}

	public void requestHour()
	{
		requestEarthquakeFeed(service.getAllHour(), view.getHourMagTextField(), view.getHourLocTextField());
	}

	public void showLargestEarthquake(
			EarthquakeFeedModel feed , 
			JTextComponent magnitudeField, 
			JTextComponent locationField)
	{
		Optional<Earthquake> largest = feed.getFeatures().stream()
				.max(Comparator.comparing(e -> e.getProperties().getMag()));

		EarthquakeProperties properties = largest.get().getProperties();

		String magnitude = String.valueOf(properties.getMag());
		String location = String.valueOf(properties.getPlace());
		magnitudeField.setText(magnitude);
		locationField.setText(location);
	}

}
