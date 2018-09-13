package elberger.earthquake.net;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import elberger.earthquake.EarthquakeFeedModel;

public interface UsgsEarthquakeService
{
	@GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojso")
	Observable<EarthquakeFeedModel> getAllMonth();
	
	@GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson")
	Observable<EarthquakeFeedModel> getAllWeek();
	
	@GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson")
	Observable<EarthquakeFeedModel> getAllDay();
	
	@GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson")
	Observable<EarthquakeFeedModel> getAllHour();
}
