package elberger.earthquake.net;

import com.google.inject.Inject;
import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeedModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.text.JTextComponent;
import java.util.List;
import java.util.stream.Collectors;

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
		requestDay();
	}

	public void requestEarthquakeFeed(Call<EarthquakeFeedModel> call, JTextComponent e1, JTextComponent e2,
									  JTextComponent e3, JTextComponent e4, JTextComponent e5)
	{
		call.enqueue(new Callback<EarthquakeFeedModel>()
		{
			@Override
			public void onResponse(Call<EarthquakeFeedModel> call, Response<EarthquakeFeedModel> response)
			{
				EarthquakeFeedModel feed = response.body();

				showEarthquakes(feed, e1, e2, e3, e4, e5);
			}

			@Override
			public void onFailure(Call<EarthquakeFeedModel> callMonth, Throwable t)
			{
				t.printStackTrace();
			}
		});
	}

	public void requestDay()
	{
		requestEarthquakeFeed(service.getAllDay(), view.getE1(), view.getE2(), view.getE3(),
				view.getE4(), view.getE5());
	}

	public void showEarthquakes(EarthquakeFeedModel feed, JTextComponent e1, JTextComponent e2,
								JTextComponent e3, JTextComponent e4, JTextComponent e5)
	{
		List<Earthquake> earthquakes = feed.getFeatures()
				.stream()
				.filter(earthquake -> earthquake.getProperties().getMag() >= 1.0)
				.sorted((a, b) -> a.getProperties().getMag() > b.getProperties().getMag() ? -1 : 1)
				.limit(5)
				.collect(Collectors.toList());


		e1.setText(earthquakes.get(0).getProperties().getPlace() + ": " + earthquakes.get(0).getProperties().getMag());
		e2.setText(earthquakes.get(1).getProperties().getPlace() + ": " + earthquakes.get(1).getProperties().getMag());
		e3.setText(earthquakes.get(2).getProperties().getPlace() + ": " + earthquakes.get(2).getProperties().getMag());
		e4.setText(earthquakes.get(3).getProperties().getPlace() + ": " + earthquakes.get(3).getProperties().getMag());
		e5.setText(earthquakes.get(4).getProperties().getPlace() + ": " + earthquakes.get(4).getProperties().getMag());

	}
}
