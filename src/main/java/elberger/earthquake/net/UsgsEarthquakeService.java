package elberger.earthquake.net;

import retrofit2.Call;
import retrofit2.http.GET;
import elberger.earthquake.EarthquakeFeedModel;

public interface UsgsEarthquakeService
{
	@GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojso")
	Call<EarthquakeFeedModel> getAllMonth();
	
	@GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.geojson")
	Call<EarthquakeFeedModel> getAllWeek();
	
	@GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_day.geojson")
	Call<EarthquakeFeedModel> getAllDay();
	
	@GET("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson")
	Call<EarthquakeFeedModel> getAllHour();
}
