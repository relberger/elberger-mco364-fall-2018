package elberger.earthquake.net;

import com.google.inject.Inject;
import elberger.earthquake.Earthquake;
import elberger.earthquake.Earthquake3;
import elberger.earthquake.EarthquakeFeedModel;
import elberger.earthquake.EarthquakeProperties;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.text.JTextComponent;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EarthquakeController3
{
	private EarthquakeView3 view;
	private UsgsEarthquakeService service;

	@Inject
	public EarthquakeController3(EarthquakeView3 view, UsgsEarthquakeService service)
	{
		this.view = view;
		this.service = service;
	}

	public void refreshData()
	{
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

	public void requestHour()
	{
		requestEarthquakeFeed(service.getAllHour(), view.getHourMagTextField(), view.getHourLocTextField());
	}

	public void showLargestEarthquake(
			EarthquakeFeedModel feed , 
			JTextComponent magnitudeField, 
			JTextComponent locationField)
	{
		/*List<Earthquake3> earthquake = feed.getFeatures()
				.stream()
				.filter(e -> e.getProperties().getMag() >= 1.2)
				.sorted(Comparator.comparing(Earthquake3::getMagnitude).reversed())
				.limit(5)
				.collect(Collectors.toList());
*/
		/*String magnitude = String.valueOf(properties.getMag());
		String location = String.valueOf(properties.getPlace());
		magnitudeField.setText(magnitude);
		locationField.setText(location);*/
	}

}
