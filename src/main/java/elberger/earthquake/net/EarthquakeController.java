package elberger.earthquake.net;

import com.google.inject.Inject;
import elberger.earthquake.Earthquake;
import elberger.earthquake.EarthquakeFeedModel;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import javax.swing.text.JTextComponent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class EarthquakeController
{
	private EarthquakeView view;
	private UsgsEarthquakeService service;
	Disposable disposable;

	@Inject
	public EarthquakeController(EarthquakeView view, UsgsEarthquakeService service)
	{
		this.view = view;
		this.service = service;
	}

	public void refreshData()
	{
		disposable = Observable.interval(0, 30, TimeUnit.SECONDS)
				.flatMap(aLong -> service.getAllDay())
				.map(feed -> feed.getFeatures())
				.subscribeOn(Schedulers.io())
				.observeOn(Schedulers.single())
				.subscribe(this::setEarthquakes,
				throwable -> System.out.println("Error"));
	}

	private void setEarthquakes(List<Earthquake> list)
	{
		List<Earthquake> earthquakes = list
				.stream()
				.filter(earthquake -> earthquake.getProperties().getMag() >= 1.0)
				.sorted((a, b) -> a.getProperties().getMag() > b.getProperties().getMag() ? -1 : 1)
				.limit(5)
				.collect(Collectors.toList());
		display(view.getE1(), view.getE2(), view.getE3(), view.getE4(), view.getE5(), earthquakes);
	}

	private void display(JTextComponent e1, JTextComponent e2, JTextComponent e3, JTextComponent e4, JTextComponent e5, List<Earthquake> earthquakes)
	{
		e1.setText(earthquakes.get(0).getProperties().getPlace() + ": " + earthquakes.get(0).getProperties().getMag());
		e2.setText(earthquakes.get(1).getProperties().getPlace() + ": " + earthquakes.get(1).getProperties().getMag());
		e3.setText(earthquakes.get(2).getProperties().getPlace() + ": " + earthquakes.get(2).getProperties().getMag());
		e4.setText(earthquakes.get(3).getProperties().getPlace() + ": " + earthquakes.get(3).getProperties().getMag());
		e5.setText(earthquakes.get(4).getProperties().getPlace() + ": " + earthquakes.get(4).getProperties().getMag());
	}

	public void stop()
	{
		disposable.dispose();
	}
}
